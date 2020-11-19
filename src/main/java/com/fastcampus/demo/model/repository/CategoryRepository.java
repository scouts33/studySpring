package com.fastcampus.demo.model.repository;

import com.fastcampus.demo.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByType(String type);

    Optional<Category> findByTitle(String title);
}
