package com.flow.blockfileextension.controller;

import com.flow.blockfileextension.domain.dto.ExtensionDto;
import com.flow.blockfileextension.service.ExtensionService;
import com.flow.blockfileextension.util.NameValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public ResponseEntity<?> addCustomExtension(@RequestParam("extensionName") String extensionName) {
        if (NameValidation.isValidNameLength(extensionName)) {
            return new ResponseEntity<>("too long, please Within 20 characters", HttpStatus.BAD_REQUEST);
        }
        if (NameValidation.isLowerCase(extensionName)) {
            return new ResponseEntity<>("Please write it in lower-case English", HttpStatus.BAD_REQUEST);
        }
        if (extensionService.existByExtensionName(extensionName)) {
            return new ResponseEntity<>("duplicateName", HttpStatus.BAD_REQUEST);
        }
        if (!extensionService.countCustomExtension(extensionName)) {
            return new ResponseEntity<>("over", HttpStatus.BAD_REQUEST);
        }
        extensionService.saveCustomExtension(extensionName);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<ExtensionDto> getAllExtention() {
        ExtensionDto extensionDto = extensionService.findExtensions();
        return new ResponseEntity<ExtensionDto>(extensionDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomExtension(@RequestParam("extensionName") String extensionName) {
        extensionService.deleteCustomExtension(extensionName);
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }

    @PostMapping("/activate")
    public ResponseEntity<?> activateFixedExtension(@RequestParam("extensionName") String extensionName) {
        extensionService.activateFixedExtension(extensionName);
        return new ResponseEntity<>("Activated", HttpStatus.OK);
    }

    @PostMapping("/deactivate")
    public ResponseEntity<?> deactivateFixedExtension(@RequestParam("extensionName") String extensionName) {
        extensionService.deActivateFixedExtension(extensionName);
        return new ResponseEntity<>("DeAtivated", HttpStatus.OK);
    }

}
