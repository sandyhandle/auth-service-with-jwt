package com.sandyhandle.webapp.finathon.application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/guest")
public class GuestController {

    @GetMapping("/hello")
    public ResponseEntity<String> guestHello(){
        return ResponseEntity.ok("Hello Guest..! Welcome to our Service.");
    }
}
