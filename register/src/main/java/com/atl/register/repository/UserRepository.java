package com.atl.register.repository;

import com.atl.register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    String findByEmail(String email);
}
