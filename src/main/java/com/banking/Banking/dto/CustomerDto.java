package com.banking.Banking.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
//public class CustomerDto {
//    private Integer partyid;
//    private String isjoint;
//    private String nametitle;
//    private String firstname;
//    private String middlename;
//    private String surname;
//    private String dob;
//    private int age;
//    private String gender;
//    private String religion;
//    private String category;
//    private String subcast;
//    private String education;
//    private String occupation;
//    private String pan;
//    private Long adhar;
//    private MultipartFile photo;
//    private MultipartFile sign;
//    private String PhotoPath;     // For displaying existing photo
//    private String SignPath;      // For displaying existing signature
//        private String SMS;
//
//
//        private String OpeningDate;
//
//        private String ManualCode;
//
//        private String Address;
//
//        private String OfficeAddress;
//
//        private Long PhoneNo;
//
//        private Long MobileNo;
//
//        private String Village;
//
//        private String City;
//
//        private String State;
//
//        private String Country;
//
//        private String Email;
//
//        private Long Pin;
//
//    private String  AddressProof;
//
//
//    private String IDProofpath;     // For displaying existing photo
//
//    private String AddProofpath;
//
//    private MultipartFile IDProofPhoto;
//
//
//    private MultipartFile  AddProof;
//
//
//    private String Identity;
//
//
//    private String BankName;
//
//
//    private String AccountNo;
//
//    private String IFSC;
//
//    private Boolean seniorCitizen;
//
//    private Boolean active;
//}


public class CustomerDto {
    private Integer partyid;
    private String isjoint;
    private String nametitle;
    private String firstname;
    private String middlename;
    private String surname;
    private LocalDate dob; // Changed to LocalDate for proper date handling
    private Integer age; // Changed to Integer to handle null values
    private String gender;
    private String religion;
    private String category;
    private String subcast;
    private String education;
    private String occupation;
    private String pan;
    private Long adhar;
    private MultipartFile photo;
    private MultipartFile sign;
    private String PhotoPath;
    private String SignPath;
    private String SMS;
    private LocalDate OpeningDate; // Changed to LocalDate for proper date handling
    private String ManualCode;
    private String Address;
    private String OfficeAddress;
    private Long PhoneNo;
    private Long MobileNo;
    private String Village;
    private String City;
    private String State;
    private String Country;
    private String Email;
    private Long Pin;
    private String AddressProof;
    private String IDProofpath;
    private String AddProofpath;
    private MultipartFile IDProofPhoto;
    private MultipartFile AddProof;
    private String Identity;
    private String BankName;
    private String AccountNo;
    private String IFSC;
    private Boolean seniorCitizen;
    private Boolean active;
}
