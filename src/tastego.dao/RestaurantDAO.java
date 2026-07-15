package com.tastego.dao;

import java.util.List;
import com.tastego.model.Restaurant;

public interface RestaurantDAO {

    List<Restaurant> getAllRestaurants();

    Restaurant getRestaurantById(int restaurantId);

    List<Restaurant> searchRestaurant(String keyword);

}
