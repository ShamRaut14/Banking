package com.banking.Banking.repo;

import com.banking.Banking.entity.Category;
import com.banking.Banking.entity.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findByReligion(Religion religion);
}
