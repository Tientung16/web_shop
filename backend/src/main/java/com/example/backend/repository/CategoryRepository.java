package com.example.backend.repository;

import com.example.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//kế thừa Jpa sẵn hàm find id, find all,...
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
