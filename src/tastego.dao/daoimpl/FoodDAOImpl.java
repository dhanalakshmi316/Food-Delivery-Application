package com.tastego.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tastego.dao.FoodDAO;
import com.tastego.model.FoodItem;
import com.tastego.util.DBConnection;

public class FoodDAOImpl implements FoodDAO {

    private Connection connection;

    public FoodDAOImpl() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<FoodItem> getFoodByRestaurant(int restaurantId) {

        List<FoodItem> foodList = new ArrayList<>();

        String sql = "SELECT * FROM food_items WHERE restaurant_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, restaurantId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FoodItem food = new FoodItem();

                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setFoodName(rs.getString("food_name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));
                food.setImage(rs.getString("image"));
                food.setAvailable(rs.getBoolean("available"));

                foodList.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodList;
    }

    @Override
    public FoodItem getFoodById(int foodId) {

        String sql = "SELECT * FROM food_items WHERE food_id=?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, foodId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                FoodItem food = new FoodItem();

                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setFoodName(rs.getString("food_name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));
                food.setImage(rs.getString("image"));
                food.setAvailable(rs.getBoolean("available"));

                return food;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<FoodItem> searchFood(String keyword) {

        List<FoodItem> foodList = new ArrayList<>();

        String sql = "SELECT * FROM food_items WHERE food_name LIKE ? OR description LIKE ?";

        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                FoodItem food = new FoodItem();

                food.setFoodId(rs.getInt("food_id"));
                food.setRestaurantId(rs.getInt("restaurant_id"));
                food.setCategoryId(rs.getInt("category_id"));
                food.setFoodName(rs.getString("food_name"));
                food.setDescription(rs.getString("description"));
                food.setPrice(rs.getDouble("price"));
                food.setImage(rs.getString("image"));
                food.setAvailable(rs.getBoolean("available"));

                foodList.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodList;
    }

}
