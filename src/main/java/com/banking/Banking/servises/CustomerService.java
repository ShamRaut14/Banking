package com.banking.Banking.servises;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.entity.Customer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CustomerService {

    CustomerDto createCustemer(CustomerDto customerDto) throws IOException;

    int getNextPartyId();

    CustomerDto getCustomerByPartyId(int partyid);


    //List<Integer> getAllPartyIds();

    boolean checkIfPartyIdExists(Integer partyid);

    List<CustomerDto> getCustomersByFirstnameandsurname(String query);

    void deletpartyidData(Integer partyid);

    void update (CustomerDto customerDto) throws IOException;


    List<CustomerDto> getAllCustomers();
}
