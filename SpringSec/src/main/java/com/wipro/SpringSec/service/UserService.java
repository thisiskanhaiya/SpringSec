package com.wipro.SpringSec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wipro.SpringSec.model.User;
import com.wipro.SpringSec.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtServ jwtServ;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
   
    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
    public String verify(User user) {
        Authentication authentication = 
          authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
          if(authentication.isAuthenticated())
                return jwtServ.generateToken(user.getUsername());
          else
                return "Failure";
          
    }

}
