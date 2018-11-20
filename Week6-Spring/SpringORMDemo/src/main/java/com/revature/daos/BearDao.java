package com.revature.daos;

import java.util.List;

import com.revature.models.Bear;

public interface BearDao {
	
	public List<Bear> getBears();
	public Bear getBearById(int id);
	//other CRUD methods

}
