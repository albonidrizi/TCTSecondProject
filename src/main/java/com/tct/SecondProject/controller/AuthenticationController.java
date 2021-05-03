package com.tct.SecondProject.controller;

import com.tct.SecondProject.model.User;
import com.tct.SecondProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String,String> register(@RequestBody User user){
        Map<String,String> response = new HashMap<>();

        UUID token = UUID.randomUUID();

        //Hash funksioni i cili na lejon qe te fshehim pasw ne database
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setVerificationToken(token.toString());
        userRepository.save(user);

        response.put("token", token.toString());
        return response;
    }


    @PostMapping("/verifyAccount")
    public void register(@RequestBody Map<String,String> request){
        String token = request.get("token");
        User user = userRepository.findByVerificationToken(token);
        user.setEnaible(true);
        userRepository.save(user);
    }

}
