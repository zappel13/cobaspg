/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.demo.dto.CustomersDTO;
import com.example.demo.entity.Customers;
import com.example.demo.repo.CustomersRepo;
import com.example.demo.service.CustomersService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kelvin
 */
@RestController
@RequestMapping("/demo")
public class NewRestController {
@Autowired
    CustomersService customersService;
    CustomersRepo customerRepo;
    
    @GetMapping("/Customers")
    public List<Customers> listCustomers() {
        return customersService.findAllCustomers();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/CID/{customersId}")
    public List<CustomersDTO> listIdByFistName(@PathVariable BigDecimal customersId) {
        System.out.println("----PRINT CUSTOMER BY ID CUSTOMER----");
        return customersService.findByCustomersId(customersId);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/CFN/{fistName}")
    public List<CustomersDTO> listIdByFistName(@PathVariable String fistName) {
        System.out.println("----PRINT CUSTOMER BY FIST NAME----");
        return customersService.findByFirstName(fistName);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/CLN/{fistName}")
    public List<CustomersDTO> listIdByLastName(@PathVariable String lastName) {
        System.out.println("----PRINT CUSTOMER BY LAST NAME----");
        return customersService.findByLastName(lastName);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/CPN/{phoneNumber}")
    public List<CustomersDTO> listIdByPhoneNumber(@PathVariable String phoneNumber) {
        System.out.println("----PRINT CUSTOMER BY PHONE Number----");
        return customersService.findByPhoneNumber(phoneNumber);
    }
    
    @DeleteMapping("/CDEL/{customersId}")
    public ResponseEntity<Object> delete(@RequestBody CustomersDTO input, @PathVariable BigDecimal customersId) {
        System.out.println("----DELETE CUSTOMER BY Customer ID----");
        return customersService.deleteCustomers(customersId, input);
    }
    
    @PutMapping("/CUPD/{customersId}")
    public ResponseEntity<Object> update(@RequestBody CustomersDTO input, @PathVariable BigDecimal customersId) {
        System.out.println("----UPDATE CUSTOMER BY Customer ID----");
	return customersService.updateCustomers(customersId, input);
    }
    
    @PostMapping("/CADD")
    public ResponseEntity<Object> add(@RequestBody CustomersDTO input) {
	System.out.println("----ADD CUSTOMER----");
        BigDecimal idCust = input.getCustomersId();
	return customersService.addCustomers(input);
    }
    
//    @ApiOperation(value = "update Customers by customersId")
//    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", value = "/CU/customersId")
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Success")
//    })
//    public ResponseEntity<Object> put(@RequestParam BigDecimal customersId, @RequestBody CustomersDTO input) {
//        System.out.println("Customers ID : " + customersId);
//        return customersService.updateCustomers(customersId, input);
//    }

//    @PutMapping("/CU/{customersId}")
//	public ResponseEntity<Customers> updateCustomer(@RequestBody Customers cust, @PathVariable BigDecimal customersId) {
//
//		List<CustomersDTO> customers = customersService.findByCustomersId(customersId);
//
//		if (!customers.isEmpty())
//			return ResponseEntity.notFound().build();
//
//		cust.setId(customersId);
//		
//		customerRepo.save(cust);
//
//		return ResponseEntity.noContent().build();
//	}
    
//    @PutMapping("/{id}")
//    public ResponseEntity<CustomersDTO> put(@PathVariable String id, @RequestBody CustomersDTO input) {
//        System.out.println("-------PUT");
//        return null;
//    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Object input) {
        System.out.println("-----Post----");
        return null;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
