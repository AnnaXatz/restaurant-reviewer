# Restaurant Reviewer App

This Spring Boot application, named "restaurant-reviewer," allows users to manage and review restaurants. Users can insert new restaurants, add dishes with their prices, view all restaurants, update restaurant information, and delete restaurants. The application is built using Java 11 (Amazon Corretto), Spring Boot, Maven, MySQL, and Thymeleaf.

## Features

- Insert new restaurants.
- Add three dishes with prices in euros for each restaurant.
- View all restaurants.
- Update restaurant information (Note: Restaurant name cannot be modified during updates).
- Delete a restaurant.
- Ensure uniqueness of restaurant names.

## How to Execute

1. **Database Setup:**
    - Open MySQL Workbench.
    - Connect to your MySQL server.
    - Execute the provided in the zip folder `db_queries.sql` script to set up the necessary database schema.

2. **Run the Application:**
    - Open the project in IntelliJ IDEA.
    - Navigate to the `Application` class.
    - Right-click on the class and choose "Run Application."

3. **Access the Application:**
    - Open a web browser.
    - Navigate to [http://localhost:8080/restaurant-reviewer/show-restaurants](http://localhost:8080/restaurant-reviewer/show-restaurants) to access the application.

## Input Constraints

The application enforces the following input constraints:

- All fields are required.
- Restaurant name: Maximum 45 characters.
- Dish names: Maximum 45 characters.
- Price: Maximum 5 digits (including 2 digits in the decimal part) and must use a dot (.) for the decimal part.

## Screenshots

Below are example screenshots of the application:

![Example Screenshot](/screenshots/view-restaurants.png)
*This screenshot illustrates the "View Restaurants" page, showcasing a list of existing restaurants in the system.*

![Example Screenshot](/screenshots/insert-restaurant.png)
*This screenshot illustrates the "Insert Restaurant" page, where users can seamlessly add new restaurants to the system. The form allows entry of essential details, including the restaurant name and three associated dishes with their prices in euros.*

![Example Screenshot](/screenshots/insert-restaurant-failure.png)
*In the event of an error during the restaurant insertion process, such as attempting to insert a restaurant with an already existing name, the application displays this screen with the message "Failed to insert restaurant."*

![Example Screenshot](/screenshots/insert-restaurant-success.png)
*Upon successfully inserting a new restaurant, the application presents this confirmation page. It includes details of the inserted restaurant, allowing users to verify the successful addition. This screen serves as a visual confirmation of the completed insertion process.*

![Example Screenshot](/screenshots/constraints-price-format.png)
*Ensuring correct price format. Also applies to update page.*

![Example Screenshot](/screenshots/constraints-price-format-decimal-digits.png)
*Ensuring correct price format. Also applies to update page.*

![Example Screenshot](/screenshots/constraints-long-name.png)
*Ensuring correct name length. Also applies to update page.*

![Example Screenshot](/screenshots/constraints-required-fields.png)
*Ensuring that all fields are required. Also applies to update page.*

![Example Screenshot](/screenshots/update-restaurant-confirmation-message.png)
*This screenshot captures the user interface when initiating a restaurant update. A popup dialog box prompts the user with a confirmation message, asking if they are sure they want to update the restaurant.*

![Example Screenshot](/screenshots/update-restaurant.png)
*In this screenshot, the "Update Restaurant" page is showcased, providing users with an interface to modify restaurant information. The form allows users to make necessary updates, while ensuring that certain details, such as the restaurant name, remain unmodifiable to maintain consistency and prevent unintended changes.*

![Example Screenshot](/screenshots/update-restaurant-success.png)
*Upon successfully updating restaurant details, users are directed to this confirmation page. It affirms the completion of the update operation and displays the modified details of the restaurant for user verification.*

![Example Screenshot](/screenshots/update-restaurant-failure.png)
*In the case of an unsuccessful attempt to update restaurant details, users are redirected to this page displaying the message "Failed to update restaurant." Users can return to "Show Restaurants" page by pressing "View Restaurants" button.*

![Example Screenshot](/screenshots/delete-restaurant-confirmation-message.png)
*When attempting to delete a restaurant, users are prompted with this confirmation message popup. If confirmed and the deletion is successful, the "Show Restaurants" page is automatically reloaded. The updated page now displays the list of restaurants, excluding the one that was deleted.*

![Example Screenshot](/screenshots/delete-restaurant-failure.png)
*In the event of a failed attempt to delete a restaurant, users are presented with a popup displaying the message "Failed to delete the restaurant." Following the failure notification, the "Show Restaurants" page is automatically reloaded to ensure users have the most up-to-date information.*


Happy dining!