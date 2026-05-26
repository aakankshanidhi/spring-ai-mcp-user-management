package com.springai.MCPServer.repository;

import com.springai.MCPServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
