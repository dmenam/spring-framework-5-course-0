package com.springboot.web.controllers;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.models.Usuario;

@RequestMapping("/app")
@Controller
public class IndexController {
	
	//Esta funcion retorna un archivo html
	@GetMapping({"/index","/",""}) //Etiqueta para mostrar mostrar una vista al cargar un URL
	public String index(Model model) {
		model.addAttribute("titulo", "Hola spring Model!");//Agregar al modelo una variable / objeto
		return "index"; //Siempre se va a buscar la vista en la carpeta templates
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("David");
		usuario.setApellido("Mena");
		usuario.setEmail("dumm2000@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		/*List<Usuario> usuarios = Arrays.asList(new Usuario("David","Mena","dumm2000@gmail.com"),
				new Usuario("Irma","Maldonado","irma@gmail.com"),
				new Usuario("Juan","Mena","juan@gmail.com"));
		
		/* Metodo 2 menos limpio
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("David","Mena","dumm2000@gmail.com"));
		usuarios.add(new Usuario("Irma","Maldonado","irma@gmail.com"));
		usuarios.add(new Usuario("Juan","Mena","juan@gmail.com"));
		*/
		
		model.addAttribute("titulo", "Lista de usuarios");
		//model.addAttribute("usuarios", usuarios);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("David","Mena","dumm2000@gmail.com"));
		usuarios.add(new Usuario("Irma","Maldonado","irma@gmail.com"));
		usuarios.add(new Usuario("Juan","Mena","juan@gmail.com"));
		return usuarios;
	}
}