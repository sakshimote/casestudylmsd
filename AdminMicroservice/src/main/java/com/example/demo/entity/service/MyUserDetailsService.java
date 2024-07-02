package com.example.demo.entity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.entity.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Admin admin=adminRepository.findByUsername(username);
		if(admin==null) {
			throw new UsernameNotFoundException("Invalid credentials");
		}
		
		List<GrantedAuthority> list=new ArrayList<>();
		String role=admin.getRole();
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
		list.add(authority);
		
		User springUser=new User(admin.getUsername(), admin.getPassword(), list);
		return springUser;
	}
	
	

}
