package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.service.AdminService;

@RestController
@RequestMapping("/admins")
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Admin>> getAllAdmins(){
		List<Admin> list=adminService.getAllUsers();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping("/post")
	public ResponseEntity<Admin> postAdmin(@RequestBody Admin admin){
		Admin admin2=adminService.addUser(admin);
		return new ResponseEntity<>(admin2,HttpStatus.CREATED);
	}
	
	@GetMapping("/get/{username}")
	public ResponseEntity<Admin> getAdminByUsername(@PathVariable String username){
		Admin admin2=adminService.getByUsername(username);
		return new ResponseEntity<>(admin2,HttpStatus.OK);
	}
	
	

}
