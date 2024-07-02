package com.example.demo.entity.service;

import java.util.List;

import com.example.demo.entity.Admin;

public interface AdminService {
	
	Admin addUser(Admin admin);
	
	Admin getByUsername(String username);
	
	List<Admin> getAllUsers();

}
