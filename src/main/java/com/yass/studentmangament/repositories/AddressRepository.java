package com.yass.studentmangament.repositories;

import com.yass.studentmangament.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
