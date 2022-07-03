package com.example.application.demo.repo;

import com.example.application.demo.entity.Address;
import com.example.application.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {


    //@Query("SELECT u FROM User u LEFT JOIN Address a ON u.id = a.user_fk WHERE a.city")
    Address findByCity(String city);
}
