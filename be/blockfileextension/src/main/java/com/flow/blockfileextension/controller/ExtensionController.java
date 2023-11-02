package com.flow.blockfileextension.controller;

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

        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<List<String>> getAllExtention() {
        List<String> extensionDtos = extensionService.findExtensionNames();
        return new ResponseEntity<List<String>>(extensionDtos, HttpStatus.OK);
    }

}
