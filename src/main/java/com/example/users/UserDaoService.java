package com.example.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Shivam", "Agarwal"));
		users.add(new User(1, "Varun", "Agarwal"));
	}

	public List<User> findAll() {
		return users;
	}
	
	public User findUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}
}
