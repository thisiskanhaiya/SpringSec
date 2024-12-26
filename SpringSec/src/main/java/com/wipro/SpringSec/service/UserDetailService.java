package com.wipro.SpringSec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wipro.SpringSec.model.User;
import com.wipro.SpringSec.model.UserPrincipal;
import com.wipro.SpringSec.repository.UserRepo;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = (User) repo.findByUsername(username);
    if (user == null) {
        throw new UsernameNotFoundException("User not found");
    }
    return new UserPrincipal(user);
    }

}
