package com.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.models.category;

public interface categoryRepository extends JpaRepository<category, Long> {

}
