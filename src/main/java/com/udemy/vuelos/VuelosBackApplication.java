package com.udemy.vuelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.vuelos.Persona;
import com.udemy.vuelos.repository.UserRepository;

@SpringBootApplication
@Controller
public class VuelosBackApplication {
	
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/hola")
	public String hola(Model model) {
		
		model.addAttribute("personas",userRepository.getAllUsersName());

		return("index");
	}
	
		  
	
	
	
	@GetMapping(path="/nombres")	
	public String getAllUsersName(String st, Model model){
		
		
		//jdbcTemplate.update("delete from persona where id>4;");
		//System.out.print("hola mundo");
		 return ("queries");
	}
	
	
	@GetMapping(path="/registrar_persona")	
	public String nuevaPersona( Model model){
		
		Persona persona=new Persona();
		model.addAttribute("persona",persona);
		 return ("nueva_persona");	  

	}	

	
	

	@PostMapping(path="/registrar_persona")	
	public String PersonaCreada(@ModelAttribute Persona persona){
		jdbcTemplate.update("Insert into persona(nombre) VALUES ('"+persona.getNombre()+"')");
		System.out.print(persona.getNombre());
		 return ("nueva_persona_POST");	  

	}
	
		
	
	public static void main(String[] args) {
		SpringApplication.run(VuelosBackApplication.class, args);
	}

}
