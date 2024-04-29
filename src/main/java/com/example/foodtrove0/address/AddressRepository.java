package com.example.foodtrove0.address;

import com.example.foodtrove0.address.entity.Address;
import com.example.foodtrove0.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends GenericRepository<Address, UUID> {
}
