package com.example.buoi8_sboot_jpa.rest;

import com.example.buoi8_sboot_jpa.model.request.LoginRequest;
import com.example.buoi8_sboot_jpa.model.request.RegisterRequest;
import com.example.buoi8_sboot_jpa.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthResource {
    @Autowired
    private final  AuthService authService;
   @PostMapping("/dang-nhap")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
       authService.login(request);
       return ResponseEntity.ok().build();
   }
    @PostMapping("/dang-ky")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request ) {
       authService.register(request);
        return ResponseEntity.ok().build();
    }
}
