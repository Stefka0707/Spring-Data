package com.example.springdataintroexercise.repository;

import com.example.springdataintroexercise.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long>{

}
