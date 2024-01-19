package com.sandyhandle.webapp.finathon.application.repository;

import com.sandyhandle.webapp.finathon.application.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByEmail(String email);
}
