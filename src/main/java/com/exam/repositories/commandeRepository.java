package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.commande;

public interface commandeRepository extends JpaRepository<commande, Long> {

}
