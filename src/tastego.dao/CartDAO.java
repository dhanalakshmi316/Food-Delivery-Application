package com.tastego.dao;

import java.util.List;

import com.tastego.model.Cart;

public interface CartDAO {

    boolean addToCart(Cart cart);

    boolean updateQuantity(int cartId, int quantity);

    boolean removeItem(int cartId);

    List<Cart> getCartItems(int userId);

    boolean clearCart(int userId);

}
