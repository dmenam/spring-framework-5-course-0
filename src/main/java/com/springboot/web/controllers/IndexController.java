package com.springboot.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.web.models.Usuario;

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
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));
		return "perfil";
	}

}