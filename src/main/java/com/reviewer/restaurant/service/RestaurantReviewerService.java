package com.reviewer.restaurant.service;

import com.reviewer.restaurant.model.dto.RestaurantDto;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface RestaurantReviewerService {
    void insertRestaurant(RestaurantDto restaurantDto) throws Exception;
    void updateRestaurant(RestaurantDto restaurantDto) throws Exception;
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto getRestaurantForUpdateById(Long restaurantId) throws EntityNotFoundException;
    void deleteRestaurantById(Long restaurantId) throws EntityNotFoundException;
}
