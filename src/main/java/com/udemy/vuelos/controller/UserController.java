package com.udemy.vuelos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.vuelos.Persona;
import com.udemy.vuelos.repository.UserRepository;

@SpringBootApplication
@Controller
@RestController
//@RequestMapping(path="/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/mail")
	public String getMail(String st, Model model){
		
		
		//jdbcTemplate.update("delete from persona where id>4;");
		//System.out.print("hola mundo");
		 return ("Form_mail");
	}	

			
		
	
	
	@PostMapping("/registrar_persona")	
	public String PersonaCreada(@ModelAttribute Persona persona){
		jdbcTemplate.update("Insert into persona(nombre) VALUES ('"+persona.getNombre()+"')");
		System.out.print(persona.getNombre());
		 return ("nueva_persona_POST");	  

	}
	
		
		
		
	
		
}