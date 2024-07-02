package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.entity.Admin;
;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private WebClient webClient;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Admin admin=webClient.get().uri("http://localhost:8005/admins/get/"+username).retrieve().bodyToMono(Admin.class).block();
		
		if(admin==null) {
			throw new UsernameNotFoundException("user with username "+username+" not found");
		}
		List<GrantedAuthority> list=new ArrayList<>();
		String role=admin.getRole();
		SimpleGrantedAuthority authority=new SimpleGrantedAuthority(role);
		list.add(authority);
		
		User springUser=new User(username,admin.getPassword(),list);
		return springUser;
		
	}
}