package com.cognizant.truYum.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truYum.TruYumApplication;
import com.cognizant.truYum.dao.MenuItemDao;
import com.cognizant.truYum.model.MenuItem;

@Service
public class MenuItemService {
	
	@Autowired
	private  MenuItemDao menuItemDao; 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TruYumApplication.class);
	
	public ArrayList<MenuItem> getMenuItemListCustomer() {
		LOGGER.debug("MenuItemService.getMenuItemListCustomer() START");
		LOGGER.debug("MenuItemService.getMenuItemListCustomer() ENDS");
		
		return menuItemDao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItem(int id) {
		return menuItemDao.getmenuItem(id);
	}
	
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}
}
