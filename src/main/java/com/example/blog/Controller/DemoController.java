package com.example.blog.Controller;

import com.example.blog.Service.AuthenticationService;
import com.example.blog.Request.AuthenticationRequest;
import com.example.blog.Request.RegistererRequest;
import com.example.blog.Response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
    @GetMapping
    public ResponseEntity<String> sayHello(){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("principal"+ principal);

        return ResponseEntity.ok("Hello from secured endpoint");
    }

}
