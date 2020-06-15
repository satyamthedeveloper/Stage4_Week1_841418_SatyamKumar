package com.cognizant.truYum.dao;

public interface CartDao {

	void addCartItem(String userId, int menuItemId);

	void getAllCartItems(String userId);

	void deleteCartItem(String userId, int menuItemId);

}
