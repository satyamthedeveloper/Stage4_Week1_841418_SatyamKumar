package com.cognizant.truYum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truYum.TruYumApplication;
import com.cognizant.truYum.dao.CartDao;

@Service
public class CartService {

	@Autowired
	CartDao cartDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	
	public void addCartItem(String userId, int menuItemId) {
		LOGGER.debug("addCartService Starts");
		cartDao.addCartItem(userId, menuItemId);
		LOGGER.debug("addCartService Ends");
	}

	public void getAllCartItems(String userId) {
		LOGGER.debug("getAllCartItemsService Starts");
		cartDao.getAllCartItems(userId);
		LOGGER.debug("getAllCartItemsService Ends");
		
	}

	public void deleteCartItem(String userId, int menuItemId) {
		LOGGER.debug("deleteCartItemService Starts");
		cartDao.deleteCartItem(userId, menuItemId);
		LOGGER.debug("deleteCartItemService Ends");
	}

}
