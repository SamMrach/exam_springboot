package com.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.produit;

public interface produitRepository extends JpaRepository<produit, Long> {
   List<produit> findByNameContainingIgnoreCase(String keyword);
}
