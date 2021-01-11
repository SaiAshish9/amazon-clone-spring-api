package com.amazon.springapi.controllers.user;

import com.amazon.springapi.repository.user.UserRepository;
import com.amazon.springapi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrentEmailController {


    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/api/get-email")
    public ResponseEntity<?> getEmail(@RequestParam("token") String token){
        Map username=new HashMap();
        username.put("email",jwtUtil.extractUsername(token));
        return ResponseEntity.ok(username);

    }



}

