package com.example.users;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		List<User> users = userDaoService.findAll();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = userDaoService.findUser(id);
		
		if(user==null)
			throw new RuntimeException("User Not Found: id-"+ id);
		
	    EntityModel<User> resource = EntityModel.of(user);
	    
	    WebMvcLinkBuilder linkTo = 
	            linkTo(methodOn(this.getClass()).getAllUsers());
	    
	    resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
}
