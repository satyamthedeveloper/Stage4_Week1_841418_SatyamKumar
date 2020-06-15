package com.cognizant.truYum.dao;

import java.util.ArrayList;

import com.cognizant.truYum.model.MenuItem;

public interface CartDao {

	void addCartItem(String userId, int menuItemId);

	ArrayList<MenuItem> getAllCartItems(String userId);

	void deleteCartItem(String userId, int menuItemId);

}
