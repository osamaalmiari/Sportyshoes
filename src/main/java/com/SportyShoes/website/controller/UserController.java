package com.SportyShoes.website.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SportyShoes.website.models.Products;
import com.SportyShoes.website.models.User;
import com.SportyShoes.website.repository.UserRepository;

@RestController
@RequestMapping("userdetails")
public class UserController {
	@Autowired
	UserRepository userrepo;

	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}

	@PostMapping("addusers")
	public User addusers(@RequestBody User user) {
		return userrepo.save(user);
	}

	public List<User> getallusers() {
		List<User> allusers = (List<User>) userrepo.findAll();
		return allusers;
	}

	@GetMapping("allusers")
	public List<String> getusers() {
		List<String> box = new ArrayList<String>();
		for (int i = 0; i < getallusers().size(); i++) {
			box.add(getallusers().get(i).getUsername());
		}
		return box;

	}
	// admin can change password
	@PutMapping("changepassword")
	public User updateproduct(@RequestBody User users) {
		for (int i = 0; i < getallusers().size(); i++) {
			if (getallusers().get(i).getUserID() == users.getUserID()) {
				 getallusers().get(i).setPassword(users.getPassword());
				 return userrepo.save(getallusers().get(i));
			}
		}
		return null;
	}


}
