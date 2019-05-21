/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repo;

import com.example.demo.dto.CustomersDTO;
import com.example.demo.entity.Customers;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Kelvin
 */
public interface CustomersRepo extends JpaRepository<Customers, BigDecimal>{
    public List<Customers> findByCustomersId(@Param("customersId") BigDecimal customersId);
    public List<Customers> findByFirstName(@Param("firstName") String firstName);
    public List<Customers> findByLastName(@Param("lastName") String lastName);
    public List<Customers> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);

}
