package com.sandyhandle.webapp.finathon.application.service;


import com.sandyhandle.webapp.finathon.application.entity.AppUser;
import com.sandyhandle.webapp.finathon.application.entity.UserRole;
import com.sandyhandle.webapp.finathon.application.entity.dto.AuthenticationResponse;
import com.sandyhandle.webapp.finathon.application.entity.dto.SignInRequest;
import com.sandyhandle.webapp.finathon.application.entity.dto.SignUpRequest;
import com.sandyhandle.webapp.finathon.application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signUp(SignUpRequest signUpRequest) {
        var user = AppUser.builder()
                .name(signUpRequest.getName())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(UserRole.USER)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateTokens(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse signIn(SignInRequest signInRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getEmail(),
                        signInRequest.getPassword()
                )
        );
        var user = userRepository.findByEmail(signInRequest.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateTokens(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
