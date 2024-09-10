package com.banking.Banking.repo;

import com.banking.Banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
    Customer findTopByOrderByPartyidDesc();


    Customer findByPartyid(int partyId);


    List<Customer> findAll();


    @Query("SELECT c.partyid FROM Customer c")
    List<Integer> findAllPartyIds();

    List<Customer> findByFirstnameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String firstname, String surname);
    boolean existsByPartyid(Integer partyid);


//    @Query("SELECT CAST(c.partyid AS string) FROM Customer c WHERE CAST(c.partyid AS string) LIKE CONCAT('%', :partyid, '%')")
//    List<String> findByPartyidContaining(@Param("partyid") String partyid);
//
//    @Query("SELECT CONCAT(c.firstname, ' ', c.surname) FROM Customer c WHERE LOWER(c.firstname) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(c.surname) LIKE LOWER(CONCAT('%', :query, '%'))")
//    List<String> findNameSuggestions(@Param("query") String query);
}
