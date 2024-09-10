package com.banking.Banking.controllers;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.exceptionhandler.ApiResponse;
import com.banking.Banking.servises.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/check-partyid")
    public ResponseEntity<Map<String, Boolean>> checkPartyId(@RequestParam("partyid") Integer partyid) {
        boolean exists = customerService.checkIfPartyIdExists(partyid);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getname")
    public ResponseEntity<List<CustomerDto>> getCustomerByFirstname(@RequestParam("query") String query) {
        List<CustomerDto> matchingCustomers = customerService.getCustomersByFirstnameandsurname(query);
        return ResponseEntity.ok(matchingCustomers);
    }


    @GetMapping("/party_id")
    public ResponseEntity <CustomerDto>getPartyIds(@RequestParam("query") int query ) {
        CustomerDto customerDto = customerService.getCustomerByPartyId(query);
        if (customerDto != null) {
            return ResponseEntity.ok(customerDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getCustomerData/{partyid}")
    @ResponseBody
    public CustomerDto getCustomerData(@PathVariable int partyid) {
        CustomerDto customerDto = customerService.getCustomerByPartyId(partyid);
        return customerDto;  // Will be returned as JSON automatically by Spring
    }

    @GetMapping("/allcustomer")
    public ResponseEntity<List<CustomerDto>> getAllCustomerlist() {
        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PostMapping("/new-customer")
    public ResponseEntity<Map<String, String>> saveCustomer(@ModelAttribute CustomerDto customerDto) throws IOException {
        Map<String, String> response = new HashMap<>();



        boolean partyIdExists = customerService.checkIfPartyIdExists(customerDto.getPartyid());
        if (partyIdExists) {
            response.put("status", "party_ID_exist");
            response.put("message", "Party ID already exists..");
            System.out.println(response);
            return ResponseEntity.ok(response);
        }

        // Save customer if partyid is valid
        customerService.createCustemer(customerDto);
        response.put("status", "success");
        response.put("message", "New customer created successfully!");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Map<String, String>> updateCustomer(@ModelAttribute CustomerDto customerDto) {
        Map<String, String> response = new HashMap<>();

        try {
            if (!customerService.checkIfPartyIdExists(customerDto.getPartyid()))
            {
                response.put("status", "error");
                response.put("message", "Party ID does not exist.");
                return ResponseEntity.ok(response);
            }

            customerService.update(customerDto);
            response.put("status", "success");
            response.put("message", " customer updated successfully!");
            return ResponseEntity.ok(response);

        }
        catch (Exception e)
        {
            // Handle the exception
            response.put("status", "error");
            response.put("message", "An error occurred while updating the customer.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(response);
        }
    }

    @DeleteMapping("/deletedata/{partyid}")
    public ApiResponse deletparty (@PathVariable Integer partyid){
        this.customerService.deletpartyidData(partyid);
        return new ApiResponse("party id data is deleted successfully!","true");
    }


}
