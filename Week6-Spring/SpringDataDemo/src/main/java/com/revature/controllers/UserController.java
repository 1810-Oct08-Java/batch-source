package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

//@Controller
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
//	@ResponseBody
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
//	@ResponseBody
	public User findUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id);
	}
	
	@PostMapping
//	@ResponseBody
	public User addUser(@Valid @RequestBody User u) {
		return userService.addUser(u);
	}
	
	@PutMapping("/{id}")
//	@ResponseBody
	public User updateUser(@Valid @PathVariable("id")Integer id, @RequestBody User u) {
		u.setUserId(id);
		return userService.updateUser(u);
	}
	
	@DeleteMapping("/{id}")
//	@ResponseBody
	public User deleteUser(@PathVariable Integer id) {
		User user = new User();
		user.setUserId(id);
		return userService.deleteUser(user);
	}

//  does not follow our uniform interface
//	@PostMapping("/login")
//	@ResponseBody
//	public User loggedInUser(@RequestParam("username") String user, @RequestParam("password")String pass) {
//		return userService.login(user, pass);
//	}

}
