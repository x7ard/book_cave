package com.youcode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcode.ecommerce.entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

}
