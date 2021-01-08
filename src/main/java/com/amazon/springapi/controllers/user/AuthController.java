package com.amazon.springapi.controllers.user;

import com.amazon.springapi.dao.user.AuthRequestBody;
import com.amazon.springapi.dao.user.AuthenticationBody;
import com.amazon.springapi.entity.user.User;
import com.amazon.springapi.repository.user.UserRepository;
import com.amazon.springapi.services.jwt.MyUserDetailsService;
import com.amazon.springapi.utils.JwtUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ExampleProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequestBody r){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(r.getPassword());

        userRepository.save(
                new User(userRepository.count()+1,r.getUsername(),password,r.getEmail())
        );

        return ResponseEntity.ok("success");
    }


    @GetMapping("/api/public/users")
    public ResponseEntity<?> fetchUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationBody r) throws Exception
    {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken((String) r.getEmail(),(String) r.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername((String) r.getEmail());

        final String jwt = jwtTokenUtil.generateToken(userDetails);


        Map res = new HashMap();
        res.put("token",jwt);

        return ResponseEntity.ok(res);

    }

    @PostMapping("/refresh")
    public ResponseEntity<?>  refreshToken(@RequestBody Map r){
        System.out.println(r.get("token"));
        final String refreshToken = jwtTokenUtil.refreshToken((String) r.get("token"));
        Map<String,String> map = new HashMap<>();
        map.put("token",refreshToken);
        return ResponseEntity.ok(map);
    }

}
