package com.sandyhandle.webapp.finathon.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user-hello")
public class UserController {

    @GetMapping()
    public ResponseEntity<String> userHello(){
        return ResponseEntity.ok("Hello User..!");
    }
}
