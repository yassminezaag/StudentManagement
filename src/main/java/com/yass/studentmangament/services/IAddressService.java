package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Address;

import java.util.List;

public interface IAddressService {
    public Address createAddress(Address address);
    public List<Address> getAll();
}
