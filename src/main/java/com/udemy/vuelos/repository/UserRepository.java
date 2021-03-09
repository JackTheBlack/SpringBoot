package com.udemy.vuelos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	
		@Autowired
		JdbcTemplate jdbcTemplate;
	
	public List<String> getAllUsersName(){
		
		
		
		List<String> userNameList=new ArrayList<>();
		userNameList.addAll(jdbcTemplate.queryForList("Select nombre from persona;",String.class));
		return userNameList;
	}

}
