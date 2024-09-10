//package com.banking.Banking.initializer;
//
//import com.banking.Banking.entity.Role;
//
//import com.banking.Banking.entity.User;
//import com.banking.Banking.repo.RoleRepo;
//import com.banking.Banking.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import jakarta.annotation.PostConstruct;
//
//import java.util.Set;
//
//@Component
//public class DataInitializer {
//
//    @Autowired
//   private PasswordEncoder passwordEncoder;
//    @Autowired
//    private RoleRepo roleRepository;
//
//    @Autowired
//    private UserRepo userRepository;
//
//    @PostConstruct
//    public void init() {
//        Role adminRole = new Role("ROLE_ADMIN");
//        Role subAdminRole = new Role("ROLE_SUB_ADMIN");
//        Role customerRole = new Role("ROLE_CUSTOMER");
//
//        roleRepository.save(adminRole);
//        roleRepository.save(subAdminRole);
//        roleRepository.save(customerRole);
//
//        User admin = new User("admin@example.com",  passwordEncoder.encode("admin"), Set.of(adminRole));
//        User subAdmin = new User("subadmin@example.com", passwordEncoder.encode("subadmin"), Set.of(subAdminRole));
//        User customer = new User("customer@example.com", passwordEncoder.encode("customer"), Set.of(customerRole));
//
//        userRepository.save(admin);
//        userRepository.save(subAdmin);
//        userRepository.save(customer);
//    }
//}
//
