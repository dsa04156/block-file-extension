package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.domain.dto.ExtensionDto;
import com.flow.blockfileextension.service.ExtensionService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ExtensionController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ExtensionService extensionService;

    @PostMapping("/add")
    public ResponseEntity<?> addExtension(@RequestParam("extensionName") String extensionName) {
        //있는지 없는지 확인한 다음 있으면 count+1 없으면 생성하고 count=1 그리고 추가하고 true로
        if (!extensionService.existsByExtensionName(extensionName)) {
            extensionService.saveExtension(extensionName);
        }
        List<ExtensionDto> extensionDtos = extensionService.findExtensions();
        return new ResponseEntity<>(extensionDtos, HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<ExtensionDto>> getAllExtention() {
        List<ExtensionDto> extensionDtos = extensionService.findExtensions();
        return new ResponseEntity<List<ExtensionDto>>(extensionDtos, HttpStatus.OK);
    }

}
