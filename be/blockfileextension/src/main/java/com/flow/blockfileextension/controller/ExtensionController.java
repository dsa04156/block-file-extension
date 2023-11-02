package com.flow.blockfileextension.controller;

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
    @GetMapping("/main")
    public ResponseEntity<?> testExtension() {
//        System.out.println(1);
        
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addExtension(@RequestParam("extensionName") String extensionName) {

        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
