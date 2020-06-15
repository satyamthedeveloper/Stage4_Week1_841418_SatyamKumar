package com.cognizant.truYum.dao;

import java.util.ArrayList;

import com.cognizant.truYum.model.MenuItem;

public interface MenuItemDao {
	
	public ArrayList<MenuItem> getMenuItemListCustomer();

	public MenuItem getmenuItem(int id);
	
	public void modifyMenuItem(MenuItem menuItem);
}
