package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.Client;

public interface clientRepository extends JpaRepository<Client, Long> {

}
