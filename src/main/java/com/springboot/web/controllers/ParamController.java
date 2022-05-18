package com.springboot.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/params")
@Controller
public class ParamController {
	
	@GetMapping("/")
	public String index() {
		
		return("params/index");
	}
	
	@GetMapping("/string")
	public String ParamGetter(@RequestParam(name = "parametro", defaultValue = "Sin parametros") String texto, Model model) {
		model.addAttribute("resultado", "El resultado es: " + texto);
		return("params/ver");
	}
	
	@GetMapping("/mix-params")
	public String ParamGetter(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero enviado es: " + numero);
		return("params/ver");
	}
	
	@GetMapping("/mix-params-request")
	public String ParamGetter(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}
		catch(NumberFormatException parseError) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero enviado es: " + numero);
		return("params/ver");
	}
}
