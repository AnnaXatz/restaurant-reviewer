package com.reviewer.restaurant.repository;

import com.reviewer.restaurant.model.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    RestaurantEntity findRestaurantById(Long restaurantId);
}
