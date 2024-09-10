package com.banking.Banking.repo;

import com.banking.Banking.entity.Religion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionRepo extends JpaRepository<Religion, Long> {}
