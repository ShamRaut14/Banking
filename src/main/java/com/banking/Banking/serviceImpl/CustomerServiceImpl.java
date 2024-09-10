package com.banking.Banking.serviceImpl;

import com.banking.Banking.dto.CustomerDto;
import com.banking.Banking.entity.Customer;
import com.banking.Banking.exceptionhandler.ResourceNotFoundException;
import com.banking.Banking.repo.CustomerRepo;
import com.banking.Banking.servises.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    private final String rootDirectory = "src/main/resources/static/uploads/";
    @Override
    public CustomerDto createCustemer(CustomerDto customerDto) throws IOException {
        Customer customer =  this.modelMapper.map(customerDto, Customer.class);

        if (customerDto.getPhoto() != null && !customerDto.getPhoto().isEmpty()) {
            String photoPath = saveFile(customerDto.getPhoto());
            customer.setPhoto(photoPath);
        }
        if (customerDto.getSign() != null && !customerDto.getSign().isEmpty()) {
            String signPath = saveFile(customerDto.getSign());
            customer.setSign(signPath);
        }
        if (customerDto.getAddProof() != null && !customerDto.getAddProof().isEmpty()) {
            String AddProofpath = saveFile(customerDto.getAddProof());
            customer.setAddProof(AddProofpath);
        }
        if (customerDto.getIDProofPhoto() != null && !customerDto.getIDProofPhoto().isEmpty()) {
            String IDProofpath = saveFile(customerDto.getIDProofPhoto());
            customer.setIDProofPhoto(IDProofpath);
        }
        Customer savedCustomer = customerRepo.save(customer);
//        System.out.println("Identity ="+ customer.getIdentity());
//        System.out.println("photo ="+ customer.getPhoto());
//        System.out.println("sign ="+ customer.getSign());
//        System.out.println("id proof ="+ customer.getIDProofPhoto());
//        System.out.println("add proof ="+ customer.getAddProof());

        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    public int getNextPartyId() {
        Customer lastCustomer = customerRepo.findTopByOrderByPartyidDesc();
        return lastCustomer != null ? lastCustomer.getPartyid() + 1 :1;
    }

    @Override
    public CustomerDto getCustomerByPartyId(int partyId) {
        Customer customer = customerRepo.findByPartyid(partyId);
        if (customer != null) {
            // Log the photo and sign paths
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            customerDto.setPhotoPath(customer.getPhoto());
            customerDto.setSignPath(customer.getSign());
            return customerDto;
        }
        return null;
    }


//    @Override
//    public List<Integer> getAllPartyIds() {
//        return customerRepo.findAllPartyIds();
//    }

    @Override
    public boolean checkIfPartyIdExists(Integer partyid) {
        return customerRepo.existsByPartyid(partyid);
    }


    @Override
    public List<CustomerDto> getCustomersByFirstnameandsurname(String query) {
        List<Customer> customers = customerRepo.findByFirstnameContainingIgnoreCaseOrSurnameContainingIgnoreCase(query,query);
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void update(CustomerDto customerDto) throws IOException {
        Customer customer =  this.modelMapper.map(customerDto, Customer.class);
        if(customerDto.getPartyid() != null){
            Customer existingCustomer = customerRepo.findByPartyid(customerDto.getPartyid());
            if (existingCustomer!= null){

                existingCustomer.setIsjoint(customerDto.getIsjoint());
                existingCustomer.setNametitle(customerDto.getNametitle());
                existingCustomer.setFirstname(customerDto.getFirstname());
                existingCustomer.setMiddlename(customerDto.getMiddlename());
                existingCustomer.setSurname(customerDto.getSurname());
                existingCustomer.setDob(customerDto.getDob());
                existingCustomer.setAge(customerDto.getAge());
                existingCustomer.setGender(customerDto.getGender());
                existingCustomer.setReligion(customerDto.getReligion());
                existingCustomer.setCategory(customerDto.getCategory());
                existingCustomer.setSubcast(customerDto.getSubcast());
                existingCustomer.setEducation(customerDto.getEducation());
                existingCustomer.setOccupation(customerDto.getOccupation());
                existingCustomer.setPan(customerDto.getPan());
                existingCustomer.setAdhar(customerDto.getAdhar());
                existingCustomer.setSMS(customerDto.getSMS());
                existingCustomer.setOpeningDate(customerDto.getOpeningDate());
                existingCustomer.setManualCode(customerDto.getManualCode());
                existingCustomer.setAddress(customerDto.getAddress());
                existingCustomer.setOfficeAddress(customerDto.getOfficeAddress());
                existingCustomer.setPhoneNo(customerDto.getPhoneNo());
                existingCustomer.setMobileNo(customerDto.getMobileNo());
                existingCustomer.setVillage(customerDto.getVillage());
                existingCustomer.setCity(customerDto.getCity());
                existingCustomer.setState(customerDto.getState());
                existingCustomer.setCountry(customerDto.getCountry());
                existingCustomer.setEmail(customerDto.getEmail());
                existingCustomer.setPin(customerDto.getPin());
                existingCustomer.setAddressProof(customerDto.getAddressProof());
                existingCustomer.setIdentity(customerDto.getIdentity());
                existingCustomer.setBankName(customerDto.getBankName());
                existingCustomer.setAccountNo(customerDto.getAccountNo());
                existingCustomer.setIFSC(customerDto.getIFSC());
                existingCustomer.setActive(customerDto.getActive());
                existingCustomer.setSeniorCitizen(customerDto.getSeniorCitizen());

                // Handle file uploads: Convert files to paths or handle file storage logic
                if (!customerDto.getPhoto().isEmpty()) {
                    String photoPath = saveFile(customerDto.getPhoto());
                    existingCustomer.setPhoto(photoPath);
                }

                if (!customerDto.getSign().isEmpty()) {
                    String signPath = saveFile(customerDto.getSign());
                    existingCustomer.setSign(signPath);
                }

                if (!customerDto.getIDProofPhoto().isEmpty()) {
                    String idProofPhotoPath = saveFile(customerDto.getIDProofPhoto());
                    existingCustomer.setIDProofPhoto(idProofPhotoPath);
                }

                if (!customerDto.getAddProof().isEmpty()) {
                    String addProofPath = saveFile(customerDto.getAddProof());
                    existingCustomer.setAddProof(addProofPath);
                }
                // Save the updated customer back to the database
                customerRepo.save(existingCustomer);
            } else {
                throw new ResourceNotFoundException("Customer", "partyid", customerDto.getPartyid());
            }
        }

    }




    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers =this.customerRepo.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletpartyidData(Integer partyid) {
        Customer customer= this.customerRepo.findByPartyid(partyid);
        this.customerRepo.delete(customer);
    }


    private String saveFile(MultipartFile file) throws IOException {
        // Define a directory to save files

        File dir = new File(rootDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // Create the directory if it doesn't exist
        }

        // Save the file
        Path filePath = Paths.get(rootDirectory + file.getOriginalFilename());
        Files.write(filePath, file.getBytes());
        return "/uploads/" + file.getOriginalFilename();
    }

}
