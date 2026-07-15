package com.tastego.model;

public class FoodItem {

    private int foodId;
    private int restaurantId;
    private int categoryId;
    private String foodName;
    private String description;
    private double price;
    private String image;
    private boolean available;

    public FoodItem() {
    }

    public FoodItem(int foodId, int restaurantId, int categoryId,
            String foodName, String description,
            double price, String image, boolean available) {

        this.foodId = foodId;
        this.restaurantId = restaurantId;
        this.categoryId = categoryId;
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.image = image;
        this.available = available;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
