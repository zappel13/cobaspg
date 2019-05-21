/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.dto.CustomersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Customers;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.repo.CustomersRepo;
import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Kelvin
 */
@Service
public class CustomersService {

    @Autowired
    private CustomersRepo customerRepo;

    public List<CustomersDTO> findByCustomersId(BigDecimal customersId) {
        List<Customers> cust = customerRepo.findByCustomersId(customersId);
       
        List<CustomersDTO> list = new ArrayList<CustomersDTO>();
        for (Customers x : cust) {
             CustomersDTO dto = new CustomersDTO();
             dto.setCustomersId(x.getId());
             dto.setFistName(x.getFistname());
             dto.setLastName(x.getLastname());
             dto.setPhoneNumber(x.getPhonenumber());
            list.add(dto);
        }
        return list;
    }
    
    public List<CustomersDTO> findByFirstName(String firstName) {
        List<Customers> cust = customerRepo.findByFirstName(firstName);
       
        List<CustomersDTO> list = new ArrayList<CustomersDTO>();
        for (Customers x : cust) {
             CustomersDTO dto = new CustomersDTO();
             dto.setCustomersId(x.getId());
             dto.setFistName(x.getFistname());
             dto.setLastName(x.getLastname());
             dto.setPhoneNumber(x.getPhonenumber());
            list.add(dto);
        }
        return list;
    }
    
    public List<CustomersDTO> findByLastName(String lastName) {
        List<Customers> cust = customerRepo.findByLastName(lastName);
       
        List<CustomersDTO> list = new ArrayList<CustomersDTO>();
        for (Customers x : cust) {
             CustomersDTO dto = new CustomersDTO();
             dto.setCustomersId(x.getId());
             dto.setFistName(x.getFistname());
             dto.setLastName(x.getLastname());
             dto.setPhoneNumber(x.getPhonenumber());
            list.add(dto);
        }
        return list;
    }
    
    public List<CustomersDTO> findByPhoneNumber(String phoneNumber) {
        List<Customers> cust = customerRepo.findByPhoneNumber(phoneNumber);
       
        List<CustomersDTO> list = new ArrayList<CustomersDTO>();
        for (Customers x : cust) {
             CustomersDTO dto = new CustomersDTO();
             dto.setCustomersId(x.getId());
             dto.setFistName(x.getFistname());
             dto.setLastName(x.getLastname());
             dto.setPhoneNumber(x.getPhonenumber());
            list.add(dto);
        }
        return list;
    }

    public List<Customers> findAllCustomers() {
        return customerRepo.findAll();
    }

//    public ResponseEntity<Object> updateCustomers(BigDecimal customersId, CustomersDTO input) {
//        Optional<Customers> opCust = customerRepo.findById(customersId);
//        
//        if(!opCust.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//        
//         Customers cust = new Customers();
//         cust.setId(input.getCustomersId());
//         cust.setFistname(input.getFistName());
//         cust.setLastname(input.getLastName());
//         cust.setPhonenumber(input.getPhoneNumber());
//         customerRepo.save(cust);
//         
//          return ResponseEntity.noContent().build();
//    }

    public ResponseEntity<Object> deleteCustomers(BigDecimal customersId, CustomersDTO input) {
        Optional<Customers> opCust = customerRepo.findById(customersId);
        
        if(!opCust.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        customerRepo.deleteById(customersId);
        return ResponseEntity.noContent().build();
    }
    
    public ResponseEntity<Object> updateCustomers(BigDecimal customersId, CustomersDTO input) {
        Optional<Customers> opCust = customerRepo.findById(customersId);
        
        if(!opCust.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Customers cust = new  Customers();
        cust.setId(input.getCustomersId());
        cust.setFistname(input.getFistName());
        cust.setLastname(input.getLastName());
        cust.setPhonenumber(input.getPhoneNumber());
        System.out.println("UPDATE CUSTOMERS ID : " + cust.getId() + " , Fist Name : " + cust.getFistname() + " , Last Name : " + cust.getLastname() + " , Phone Number : " + cust.getPhonenumber());
        customerRepo.save(cust);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Object> addCustomers(CustomersDTO input) {
        Optional<Customers> opCust = customerRepo.findById(input.getCustomersId());
//        int test = input.getCustomersId().intValue();
//        BigDecimal asd = new BigDecimal(1);
         if(!opCust.isPresent()) {
             Customers cust = new  Customers();
             cust.setId(input.getCustomersId());
//             cust.setId(asd);
             cust.setFistname(input.getFistName());
             cust.setLastname(input.getLastName());
             cust.setPhonenumber(input.getPhoneNumber());
             System.out.println("ADD CUSTOMERS ID : " + cust.getId() + " , Fist Name : " + cust.getFistname() + " , Last Name : " + cust.getLastname() + " , Phone Number : " + cust.getPhonenumber());
             customerRepo.save(cust);
             return ResponseEntity.ok(cust);
        }
         System.out.println("ERROR - ID FOUNDED!");
         return ResponseEntity.badRequest().body("ERROR - ID FOUNDED!");
    }
    
}
