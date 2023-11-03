package com.flow.blockfileextension.domain.dto;

import com.flow.blockfileextension.domain.entity.CustomExtensionEntity;
import com.flow.blockfileextension.domain.entity.FixedExtensionEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtensionDto {
    private List<FixedExtensionEntity> fixedExtensionEntityList;
    private List<CustomExtensionEntity> customExtensionEntities;
}
