package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import app.service.CategoriaService;

@ControllerAdvice
public class CommonControllerAdvice {

	@Autowired
	private CategoriaService categoriaService;
	
	@ModelAttribute
	public void addAtributes(Model model){
		model.addAttribute("listar_categoria", categoriaService.findAll());
	}
	
}
