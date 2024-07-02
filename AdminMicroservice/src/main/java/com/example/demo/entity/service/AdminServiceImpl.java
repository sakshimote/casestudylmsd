package com.example.demo.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService{


	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public Admin addUser(Admin admin) {
		// TODO Auto-generated method stub
		
		String plainTextPass=admin.getPassword();
		admin.setPlainTextPassword(plainTextPass);
		String encodedPass=passwordEncoder.encode(plainTextPass);
		admin.setPassword(encodedPass);
		return adminRepository.save(admin);
	
	}

	@Override
	public Admin getByUsername(String username) {
		// TODO Auto-generated method stub
		return adminRepository.findByUsername(username);
		
	}

	@Override
	public List<Admin> getAllUsers() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}
	

}
