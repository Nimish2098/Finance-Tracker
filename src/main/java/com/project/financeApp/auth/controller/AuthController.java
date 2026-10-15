package com.project.financeApp.auth.controller;


import com.project.financeApp.auth.dto.AuthResponseDTO;
import com.project.financeApp.auth.dto.LoginRequestDTO;
import com.project.financeApp.auth.dto.RegisterRequestDTO;
import com.project.financeApp.user.entity.User;
import com.project.financeApp.user.repository.UserRepository;
import com.project.financeApp.common.security.JwtTokenProvider;
import com.project.financeApp.common.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public AuthController(
            @Lazy AuthenticationManager authenticationManager,
            @Lazy JwtTokenProvider jwtTokenProvider,
            UserRepository userRepository,
            @Lazy PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }
    @PostMapping("/register")
    public void register(@RequestBody RegisterRequestDTO request) {

        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .createdAt(LocalDateTime.now())
                .build();

        userRepository.save(user);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginRequestDTO request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(),
                                request.password()
                        )
                );

        UserPrincipal principal =
                (UserPrincipal) authentication.getPrincipal();

        String token = jwtTokenProvider.generateToken(
                principal.getUserId(),
                principal.getUsername()
        );

        return new AuthResponseDTO(token);
    }
}

