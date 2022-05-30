package com.example.back.repository;

import com.example.back.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findAllById(int id);
    Users deleteAllById(int id);
}
