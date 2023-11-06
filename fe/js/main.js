// 변수 선언
const customExtensionList = document.querySelector(".custom-extension-list");
const addCustomExtensionButton = document.querySelector(
  "#add-custom-extension"
);

const baseUrl = "http://118.67.142.103:8080/api";

// 비동기 함수 정의
async function getCustomExtensionList() {
  // fetch()를 사용하여 API에서 데이터를 가져옵니다.
  const response = await fetch(`${baseUrl}/get`);

  // 응답을 JSON으로 변환합니다.
  const data = await response.json();

  return data;
}

// customExtensionList 변수를 초기화합니다.
async function initializeCustomExtensionList() {
  const customExtensionData = await getCustomExtensionList();

  // customExtensionEntities의 데이터를 사용하여 버튼을 생성하고 추가합니다.
  customExtensionData.customExtensionEntities.forEach((entity) => {
    const button = document.createElement("button");
    button.classList.add("btn__close");
    button.innerText = entity.extensionName;
    button.id = entity.id;
    customExtensionList.appendChild(button);
  });

  // fixedExtensionEntityList의 데이터를 사용하여 체크박스에 체크를 합니다.
  customExtensionData.fixedExtensionEntityList.forEach((entity) => {
    const checkbox = document.querySelector(
      `input[type="checkbox"][value="${entity.extensionName}"]`
    );
    if (entity.isEnabled === 1) {
      checkbox.checked = true;
    }
  });
}

customExtensionList.addEventListener("click", (event) => {
  const target = event.target;
  if (target.classList.contains("btn__close")) {
    const button = target;
    console.log(button.innerText);
    const extensionNameToDelete = button.innerText;
    deleteCustomExtension(extensionNameToDelete);
    customExtensionList.removeChild(button);
  }
});

async function updateCustomExtensionCount() {
  const countElement = document.getElementById("count");

  // 서버에서 데이터 가져오기
  const response = await fetch(`${baseUrl}/count`);
  const data = await response.json();

  // 가져온 데이터를 <span>에 넣기
  countElement.textContent = `${data}/200`;
}

// 페이지가 로드될 때 또는 새로 고침될 때 데이터를 업데이트합니다.
window.addEventListener("load", updateCustomExtensionCount);

async function deleteCustomExtension(extensionName) {
  try {
    // 서버로 "delete" 요청을 보냅니다.
    const response = await fetch(
      `${baseUrl}/delete?extensionName=${extensionName}`,
      {
        method: "DELETE",
      }
    );

    if (response.status === 200) {
      console.log(`${extensionName} 확장자가 삭제되었습니다.`);
      updateCustomExtensionCount();
    } else {
      console.log(`서버 요청 실패: ${response.status}`);
    }
  } catch (error) {
    console.error("요청 오류:", error);
  }
}

// 페이지가 로드될 때 또는 새로 고침될 때 customExtensionList를 초기화합니다.
window.addEventListener("load", initializeCustomExtensionList);

// addCustomExtension 함수 정의
async function addCustomExtension() {
  // 사용자 입력 가져오기
  const customExtension = document.querySelector("#custom-extension").value;

  // 요청을 보냅니다.
  const response = await fetch(
    `${baseUrl}/add?extensionName=${customExtension}`,
    {
      method: "POST",
    }
  );

  // 응답을 처리합니다.
  if (response.status === 200) {
    // 요청이 성공적으로 처리되었습니다.
    // 버튼을 추가합니다.
    const button = document.createElement("button");
    button.classList.add("btn__close");
    button.innerText = customExtension;

    // 첫 번째 항목을 찾아서 그 뒤에 추가합니다.
    const firstButton = customExtensionList.querySelector(".btn__close");
    customExtensionList.insertBefore(button, firstButton);
    updateCustomExtensionCount();
  } else {
    // 요청이 실패했습니다.
    console.log(response);
    alert("요청에 실패했습니다.");
  }
}

// addCustomExtensionButton 이벤트 핸들러 등록
addCustomExtensionButton.addEventListener("click", addCustomExtension);

document
  .querySelectorAll('input[type="checkbox"][name="fixed-extensions"]')
  .forEach((checkbox) => {
    checkbox.addEventListener("change", async function () {
      const extensionName = this.value;
      const isChecked = this.checked;
      const action = isChecked ? "activate" : "deactivate"; // 체크 상태에 따라 활성화 또는 비활성화 동작 선택

      try {
        // 서버로 요청을 보냅니다.
        const response = await fetch(
          `${baseUrl}/${action}?extensionName=${extensionName}`,
          {
            method: "POST",
          }
        );

        if (response.status === 200) {
          console.log(`${extensionName} 확장자가 ${action}되었습니다.`);
        } else {
          console.log(`서버 요청 실패: ${response.status}`);
        }
      } catch (error) {
        console.error("요청 오류:", error);
      }
    });
  });
