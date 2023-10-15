package com.example.blog.Controller;

import com.example.blog.Request.AuthenticationRequest;
import com.example.blog.Request.RegistererRequest;
import com.example.blog.Response.AuthenticationResponse;
import com.example.blog.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistererRequest request) {

        try {
            return ResponseEntity.ok(service.register(request));
        }
        catch (Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
