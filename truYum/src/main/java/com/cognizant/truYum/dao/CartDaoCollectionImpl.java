package com.cognizant.truYum.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.truYum.TruYumApplication;

@Repository
public class CartDaoCollectionImpl implements CartDao {

//	Map<String, Cart> cartItems =  new 

	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);

	@Override
	public void addCartItem(String userId, int menuItemId) {
		LOGGER.debug("STARTS addCartItem of CartDao");

		LOGGER.debug("ENDS addCartItem of CartDao");
	}

	@Override
	public void getAllCartItems(String userId) {
		LOGGER.debug("STARTS getAllCartItems of CartDao");

		LOGGER.debug("ENDS getAllCartItems of CartDao");
	}

	@Override
	public void deleteCartItem(String userId, int menuItemId) {
		LOGGER.debug("STARTS deleteCartItem of CartDao");

		LOGGER.debug("ENDS deleteCartItem of CartDao");	
	}

}
