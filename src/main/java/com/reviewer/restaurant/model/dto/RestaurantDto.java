package com.reviewer.restaurant.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private Long restaurantId;

    @NotBlank(message = "Restaurant Name cannot be blank.")
    @Size(min = 1, max = 45, message = "Restaurant Name must be between {min} and {max} characters.")
    private String restaurantName;

    @NotBlank(message = "First Dish cannot be blank.")
    @Size(min = 1, max = 45, message = "First Dish must be between {min} and {max} characters.")
    private String firstDish;

    @NotNull(message = "First Dish Price cannot be null.")
    @Pattern(regexp = "\\d*\\.?\\d+", message = "Invalid First Dish Price format. Please enter a valid numeric value. Use a dot (.) for the decimal part.")
    @Digits(integer = 3, fraction = 2, message = "Invalid First Dish Price format. Maximum 3 digits before the decimal point and 2 digits after.")
    private String firstDishPrice;

    @NotBlank(message = "Second Dish cannot be blank.")
    @Size(min = 1, max = 45, message = "Second Dish must be between {min} and {max} characters.")
    private String secondDish;

    @NotNull(message = "Second Dish Price cannot be null.")
    @Pattern(regexp = "\\d*\\.?\\d+", message = "Invalid Second Dish Price format. Please enter a valid numeric value. Use a dot (.) for the decimal part.")
    @Digits(integer = 3, fraction = 2, message = "Invalid Second Dish Price format. Maximum 3 digits before the decimal point and 2 digits after.")
    private String secondDishPrice;

    @NotBlank(message = "Third Dish cannot be blank.")
    @Size(min = 1, max = 45, message = "Third Dish must be between {min} and {max} characters.")
    private String thirdDish;

    @NotNull(message = "Third Dish Price cannot be null.")
    @Pattern(regexp = "\\d*\\.?\\d+", message = "Invalid Third Dish Price format. Please enter a valid numeric value. Use a dot (.) for the decimal part.")
    @Digits(integer = 3, fraction = 2, message = "Invalid Third Dish Price format. Maximum 3 digits before the decimal point and 2 digits after.")
    private String thirdDishPrice;
}
