package com.banking.Banking.config;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(Customer.class, CustomerDto.class).addMappings(mapper -> {
            mapper.map(Customer::getPhoto, CustomerDto::setPhotoPath);
            mapper.map(Customer::getSign, CustomerDto::setSignPath);
            mapper.map(Customer::getAddProof, CustomerDto::setAddProofpath);
            mapper.map(Customer::getIDProofPhoto, CustomerDto::setIDProofpath);
        });


        return modelMapper;
    }
}

