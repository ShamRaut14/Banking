package com.banking.Banking.repo;

import com.banking.Banking.entity.Category;
import com.banking.Banking.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubcategoryRepo extends JpaRepository<Subcategory, Long> {
    List<Subcategory> findByCategory(Category category);
}
