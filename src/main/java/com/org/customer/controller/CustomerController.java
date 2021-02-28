package com.org.customer.controller;

import com.org.customer.model.Customer;
import com.org.customer.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
    }

   @GetMapping("/getAll")
   public List<Customer> getAllCustomer(){
     List<Customer> all  = customerRepo.findAll();
     return all;
   }

    @DeleteMapping("/delete/{name}")
    public void deleteByCustomerRecord(@PathVariable String name){
        customerRepo.deleteByCusName(name);
    }

}
