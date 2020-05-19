package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

}
