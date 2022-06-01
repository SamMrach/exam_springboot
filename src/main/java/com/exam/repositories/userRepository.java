package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.user;

public interface userRepository extends JpaRepository<user, Long> {

}
