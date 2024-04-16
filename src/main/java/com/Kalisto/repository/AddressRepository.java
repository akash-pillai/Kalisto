package com.Kalisto.repository;

import com.Kalisto.entity.Address;
import com.Kalisto.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
