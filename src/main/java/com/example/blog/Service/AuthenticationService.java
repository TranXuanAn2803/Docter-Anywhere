package com.example.blog.Service;

import com.example.blog.BlogApplication;
import com.example.blog.Entity.Role;
import com.example.blog.Entity.User;
import com.example.blog.Repository.UserRepository;
import com.example.blog.Request.AuthenticationRequest;
import com.example.blog.Request.RegistererRequest;
import com.example.blog.Response.AuthenticationResponse;
import com.example.blog.Security.JwtServevice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private  final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServevice jwtServevice;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegistererRequest request) throws Exception {
        if(request.getUsername()==null||request.getPassword()==null){
            throw new Exception("Username and password can not be null");
        }
        Optional<User> foundUser = repository.findByUsername(request.getUsername());
        if(foundUser.isPresent())
        {
            throw new Exception("Username already exist ");
        }
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        System.out.println(repository.save(user));
        var jwtToken = jwtServevice.generateToken(user);

        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
//        String username=request.getUsername()+"@gmail.com";
//        System.out.println(username);
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        username,
//                        request.getPassword()
//                )
//        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtServevice.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


}
