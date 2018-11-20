package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.revature.beans.Bear;
import com.revature.exceptions.BearNotFoundException;
import com.revature.services.BearService;

@Controller
public class BearController {
	
	@Autowired
	BearService bearService;

	@RequestMapping(value="/bears", method=RequestMethod.GET)
//	@GetMapping("/bears")
	@ResponseBody
	public List<Bear> getBears(){
		return bearService.getBears();
	}
	
	@GetMapping("/bears/{id}")
	@ResponseBody
	public Bear getBearById(@PathVariable("id") int id) {
		Bear b = bearService.getBearById(id);
		if(b==null) {
			throw new BearNotFoundException();
		}
		return b;
	}
	
	@GetMapping("/bears/search")
	public String getSearchPage() {
		return "SearchBear";
	}
	
//	@RequestMapping(value="/bears/search", method=RequestMethod.POST)
//	//@PostMapping("/bears/search")
//	public String getBear(HttpServletRequest req) {
//		String bearId = req.getParameter("id");
//		return "redirect:/bears/"+bearId;
//	}
	
	@RequestMapping(value="/bears/search", method=RequestMethod.POST)
	public String getBear(@RequestParam("id")int bearId) {
		return "redirect:/bears/"+bearId;
	}
	
	@GetMapping("/bears/create")
	public String getCreatePage() {
		return "CreateBear";
	}
	
	@PostMapping("/bears/create")
	public String addBear(@RequestParam("name") String name, @RequestParam("birthday") Date birthday) {
		bearService.addBear(new Bear(5, name, birthday));
		return "redirect:/bears";
	}
	
	@GetMapping("/teapot")
	@ResponseStatus(value=HttpStatus.I_AM_A_TEAPOT, reason="teapot not bear")
	public void teapot() {
	}
	
}
