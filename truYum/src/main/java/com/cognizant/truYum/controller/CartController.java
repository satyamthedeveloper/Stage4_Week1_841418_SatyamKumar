package com.cognizant.truYum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truYum.service.CartService;



@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(com.cognizant.truYum.TruYumApplication.class);
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable("userId") String userId, @PathVariable("menuItemId") int menuItemId) {
		LOGGER.info("addCart controller Start");
		cartService.addCartItem(userId, menuItemId);
		LOGGER.info("addCart controller Ends");
	}
	
	@GetMapping("/{userId}")
	public void getAllCartItems(@PathVariable("userID") String userId) {
		LOGGER.info("addCart controller Start");
		cartService.getAllCartItems(userId);
		LOGGER.info("addCart controller Ends");
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable("userId") String userId, @PathVariable("menuItemId") int menuItemId) {
		cartService.deleteCartItem(userId, menuItemId);
	}
}
