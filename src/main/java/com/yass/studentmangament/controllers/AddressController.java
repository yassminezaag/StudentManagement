package com.yass.studentmangament.controllers;

import com.yass.studentmangament.entities.Address;
import com.yass.studentmangament.repositories.AddressRepository;
import com.yass.studentmangament.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    IAddressService addressService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }
    @GetMapping("/getall")
    public List<Address> getAll(){
        return addressService.getAll();
    }
}
