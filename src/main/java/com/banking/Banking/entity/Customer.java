package com.banking.Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Customer_Detail")
//public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long Id;
//
//    @Column(name = "partyid")
//    @NotNull
//    private int partyid;
//
//    @Column(name = "isjoint")
//    private String isjoint;
//
//    @Column(name = "nametitle")
//    private String nametitle;
//
//    @Column(name = "firstname")
//    private String firstname;
//
//    @Column(name = "middlename")
//    private String middlename;
//
//    @Column(name = "surname")
//    private String surname;
//
//    @Column(name = "dob")
//    //@Temporal(TemporalType.DATE)
//    private String dob;
//
//    @Column(name = "age")
//    private int age;
//
//    @Column(name = "gender")
//    private String gender;
//
//    @Column(name = "religion")
//    private String religion;
//
//    @Column(name = "category")
//    private String category;
//
//    @Column(name = "subcast")
//    private String subcast;
//
//    @Column(name = "education")
//    private String education;
//
//    @Column(name = "occupation")
//    private String occupation;
//
//    @Column(name = "pan")
//    private String pan;
//
//    @Column(name = "adhar")
//    private Long adhar;
//
//    @Column(name = "photo")  // Store the path to the photo
//    private String photo;
//
//    @Column(name = "sign")   // Store the path to the signature
//    private String sign;
//
//    @Column(name = "SMS")
//    private String SMS;
//
//    @Column(name = "Opening Date")
//  //  @Temporal(TemporalType.DATE)
//    private String OpeningDate;
//
//    @Column(name = "Manuale Code")
//  //  @Temporal(TemporalType.DATE)
//    private String  ManualCode;
//
//    @Column(name ="Address" )
//    private String Address;
//
//    @Column(name = "OfficeAddress")
//    private String OfficeAddress;
//
//    @Column(name = "PhoneNo")
//    private Long PhoneNo;
//
//    @Column(name ="MobileNo" )
//    private Long MobileNo;
//
//    @Column(name ="Village" )
//    private String Village;
//
//    @Column(name ="City" )
//    private String City;
//
//    @Column(name = "State")
//    private String State;
//
//    @Column(name = "Country")
//    private String Country;
//
//    @Column(name ="Email" )
//    private String Email;
//
//    @Column(name ="Pin" )
//    private Long Pin;
//
//    @Column(name ="Add Proof" )
//    private String AddProof;
//
//    @Column(name ="Address Proof" )
//    private String  AddressProof;
//
//    @Column(name ="ID proof Photo" )
//    private String IDProofPhoto;
//
//    @Column(name ="ID Proof" )
//    private String Identity;
//
//    @Column(name ="Bank Name" )
//    private String BankName;
//
//    @Column(name ="Account No" )
//    private String AccountNo;
//
//    @Column(name ="IFSC" )
//    private String IFSC;
//
//    @Column(name = "is_senior_citizen")
//    private Boolean seniorCitizen;
//
//    @Column(name = "is_active")
//    private Boolean active;
//}


public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "partyid", nullable = false)
    private Integer partyid; // Changed to Integer for consistency with DTO

    @Column(name = "isjoint")
    private String isjoint;

    @Column(name = "nametitle")
    private String nametitle;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dob")
    private LocalDate dob; // Changed to LocalDate for proper date handling

    @Column(name = "age")
    private Integer age; // Changed to Integer to handle null values

    @Column(name = "gender")
    private String gender;

    @Column(name = "religion")
    private String religion;

    @Column(name = "category")
    private String category;

    @Column(name = "subcast")
    private String subcast;

    @Column(name = "education")
    private String education;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "pan")
    private String pan;

    @Column(name = "adhar")
    private Long adhar;

    @Column(name = "photo")  // Store the path to the photo
    private String photo;

    @Column(name = "sign")   // Store the path to the signature
    private String sign;

    @Column(name = "SMS")
    private String SMS;

    @Column(name = "Opening_Date") // Fixed column name
    private LocalDate OpeningDate; // Changed to LocalDate for proper date handling

    @Column(name = "Manual_Code") // Fixed column name
    private String ManualCode;

    @Column(name = "Address")
    private String Address;

    @Column(name = "OfficeAddress")
    private String OfficeAddress;

    @Column(name = "PhoneNo")
    private Long PhoneNo;

    @Column(name = "MobileNo")
    private Long MobileNo;

    @Column(name = "Village")
    private String Village;

    @Column(name = "City")
    private String City;

    @Column(name = "State")
    private String State;

    @Column(name = "Country")
    private String Country;

    @Column(name = "Email")
    private String Email;

    @Column(name = "Pin")
    private Long Pin;

    @Column(name = "Add_Proof") // Fixed column name
    private String AddProof;

    @Column(name = "Address_Proof") // Fixed column name
    private String AddressProof;

    @Column(name = "ID_Proof_Photo") // Fixed column name
    private String IDProofPhoto;

    @Column(name = "ID_Proof") // Fixed column name
    private String Identity;

    @Column(name = "Bank_Name") // Fixed column name
    private String BankName;

    @Column(name = "Account_No") // Fixed column name
    private String AccountNo;

    @Column(name = "IFSC")
    private String IFSC;

    @Column(name = "is_senior_citizen")
    private Boolean seniorCitizen;

    @Column(name = "is_active")
    private Boolean active;
}