package com.banking.Banking.controllers;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.dto.SchedulDto;
import com.banking.Banking.entity.Schedule;
import com.banking.Banking.servises.CustomerService;
import com.banking.Banking.servises.SchedulServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class DashboardController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SchedulServise schedulServise;

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard"; // Assuming 'dashboard.html' is in src/main/resources/templates
    }
    @GetMapping("/new_customer_aco.html")
    public String newCustomerForm(Model model) {
        int nextPartyId = customerService.getNextPartyId();
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("nextPartyId", nextPartyId);
        return "new_customer_aco";  // Thymeleaf template for the form
    }

    @GetMapping("/sharing_account.html")
    public String showSheringacount() {
        return "sharing_account";
    }
    @GetMapping("/deposite_account.html")
    public String show_deposite_account() {
        return "deposite_account";
    }
    @GetMapping("/loan_account.html")
    public String show_loan_account() {
        return "loan_account";
    }
    @GetMapping("/smallsaving.html")
    public String show_smallsaving() {
        return "smallsaving";
    }

    @GetMapping("/investment_and_security.html")
    public String show_investment_and_security() {
        return "investment_and_security";
    }

    @GetMapping("/schedule_master.html")
    public String newSchedulForm(Model model) {
        int nextScheduleId = schedulServise.getNextScheduleId();
        model.addAttribute("schedulDto", new SchedulDto());
        model.addAttribute("nextScheduleId", nextScheduleId);
        return "/schedule_master"; // Replace with your form page name
    }

     @GetMapping("/general_ledger_master.html")
     public String show_general_ledger_master() {
     return "general_ledger_master";
    }

    @GetMapping("/add-master.html")
    public String show_addmaster() {
        return "add-master.html";
    }
















//    @GetMapping("/new-customer/{partyid}")
//    public String getCustomerByPartyId(@PathVariable("partyid") int partyId, Model model) {
//        CustomerDto customerDto = customerService.getCustomerByPartyId(partyId);
//
//        if (customerDto != null) {
//            model.addAttribute("customerDto", customerDto);
//            return "new_customer_aco";  // Thymeleaf template for the form
//        } else {
//            model.addAttribute("error", "Customer not found with party ID: " + partyId);
//            return "new_customer_aco";  // Return to the form with an error message
//        }
//    }
}
