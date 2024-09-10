package com.banking.Banking.repo;

import com.banking.Banking.entity.Country;
import com.banking.Banking.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepo extends JpaRepository<State, Long> {
    List<State> findByCountry(Country country);
}
