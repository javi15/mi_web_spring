package com.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;


import com.springmvc.pojo.Usuario;
import com.springmvc.pojo.valid.SpringFormGroup;
import com.springmvc.service.UsuarioService;;

@Controller
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/usuario")
	public String showForm(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("usuarios", usuarioService.findAll());
		return "usuario";
	}
	
	@RequestMapping("/usuario/save")
	public String registrar(@ModelAttribute("usuario") @Validated(SpringFormGroup.class) Usuario usuarioFrom,
			BindingResult result,			
			Model model){
		
		if(result.hasErrors())
		{
			return "usuario";
		}
		usuarioService.save(usuarioFrom);
		return "redirect:/usuario"; //Retorna un controlador
	}
}
