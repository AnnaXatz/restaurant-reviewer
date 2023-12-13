package com.reviewer.restaurant.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RESTAURANT")
public class RestaurantEntity {

    @Id
    @Column(name = "idRESTAURANT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", unique = true)
    private String restaurantName;

    @Column(name = "FIRST_DISH")
    private String firstDish;

    @Column(name = "FIRST_DISH_PRICE")
    private BigDecimal firstDishPrice;

    @Column(name = "SECOND_DISH")
    private String secondDish;

    @Column(name = "SECOND_DISH_PRICE")
    private BigDecimal secondDishPrice;

    @Column(name = "THIRD_DISH")
    private String thirdDish;

    @Column(name = "THIRD_DISH_PRICE")
    private BigDecimal thirdDishPrice;
}
