package com.springai.MCPServer.repository;

import com.springai.MCPServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByEmail(String email);

    List<User> findByCity(String city);

    List<User> findByAge(Integer age);

    List<User> findByAgeGreaterThan(Integer age);

    List<User> findByNameContainingIgnoreCase(String name);
}
