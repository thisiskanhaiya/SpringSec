package com.wipro.SpringSec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.SpringSec.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    Object findByUsername(String username);
}
