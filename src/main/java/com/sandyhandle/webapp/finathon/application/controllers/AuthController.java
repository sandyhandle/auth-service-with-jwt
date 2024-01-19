package com.sandyhandle.webapp.finathon.application.controllers;


import com.sandyhandle.webapp.finathon.application.entity.dto.AuthenticationResponse;
import com.sandyhandle.webapp.finathon.application.entity.dto.SignInRequest;
import com.sandyhandle.webapp.finathon.application.entity.dto.SignUpRequest;
import com.sandyhandle.webapp.finathon.application.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationResponse> signIn(@RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }

}
