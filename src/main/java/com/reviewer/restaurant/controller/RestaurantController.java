package com.reviewer.restaurant.controller;

import com.reviewer.restaurant.model.dto.RestaurantDto;
import com.reviewer.restaurant.service.RestaurantReviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/restaurant-reviewer")
public class RestaurantController {

    private final RestaurantReviewerService restaurantReviewerService;

    @RequestMapping(path = "/insert-restaurant", method = RequestMethod.GET)
    public String insertRestaurant(Model model) {
        model.addAttribute("restaurantDto", new RestaurantDto());
        return "insert-restaurant";
    }

    @RequestMapping(path = "/insert-restaurant", method = RequestMethod.POST)
    public String insertRestaurant(@Valid @ModelAttribute("restaurantDto") RestaurantDto restaurantDto,
                                   BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "insert-restaurant";
        }
        model.addAttribute("restaurantDto", restaurantDto);
        try {
            restaurantReviewerService.insertRestaurant(restaurantDto);
        } catch (Exception e) {
            return "insert-failure";
        }
        return "insert-success";
    }

    @RequestMapping(path = "/show-restaurants", method = RequestMethod.GET)
    public String showRestaurants(Model model) {

        List<RestaurantDto> restaurants = restaurantReviewerService.getAllRestaurants();

        model.addAttribute("restaurants", restaurants);
        return "show-restaurants";
    }

    @RequestMapping(path = "/update-restaurant/{restaurantId}", method = RequestMethod.GET)
    public String updateRestaurant(@PathVariable Long restaurantId, Model model) {

        try {
            RestaurantDto restaurantDto = restaurantReviewerService.getRestaurantForUpdateById(restaurantId);
            model.addAttribute("restaurantDto", restaurantDto);
        } catch (Exception e) {
            return "update-failure";
        }
        return "update-restaurant";
    }

    @RequestMapping(path = "/update-restaurant", method = RequestMethod.POST)
    public String updateRestaurant(@Valid @ModelAttribute("restaurantDto") RestaurantDto restaurantDto,
                                   BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "update-restaurant";
        }
        model.addAttribute("restaurantDto", restaurantDto);
        try {
            restaurantReviewerService.updateRestaurant(restaurantDto);
        } catch (Exception e) {
            return "update-failure";
        }
        return "update-success";
    }

    @RequestMapping(path = "/delete-restaurant/{restaurantId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long restaurantId) {
        try {
            restaurantReviewerService.deleteRestaurantById(restaurantId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
