package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.panier;

public interface panierRepositiry extends JpaRepository<panier, Long> {

}
