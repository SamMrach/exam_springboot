package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.produit;

public interface produitRepository extends JpaRepository<produit, Long> {

}
