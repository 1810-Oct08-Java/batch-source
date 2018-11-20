package com.revature.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Bear;

@Service
public class BearService {

	private List<Bear> bears = new ArrayList();
	
	public BearService() {
		bears.add(new Bear(1, "Yogi", Date.valueOf("1950-10-9")));
		bears.add(new Bear(2, "Pooh", Date.valueOf("1920-04-12")));
		bears.add(new Bear(3, "Gerald", Date.valueOf("2015-02-14")));
	}
	
	public List<Bear> getBears(){
		return this.bears;
	}
	
	public Bear getBearById(int id) {
		for(Bear b : bears ) {
			if(id == b.getId()) {
				return b;
			}
		}
		return null;
	}
	
	public void addBear(Bear b) {
		this.bears.add(b);
	}
}
