package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Address;
import com.yass.studentmangament.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService{
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }
}
