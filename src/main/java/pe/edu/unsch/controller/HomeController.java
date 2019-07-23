package pe.edu.unsch.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.model.Cliente;
import pe.edu.unsch.model.Producto;
import pe.edu.unsch.service.ClienteService;
import pe.edu.unsch.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	ProductoService productoService;
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("productos_destacados", productoService.destacado(4));
		model.addAttribute("productos_recientes",productoService.reciente(4));
		return "views/public/home/index";
		
	}

	@RequestMapping(value = "/verCategoria", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getResponsable(HttpServletRequest r) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id_producto = Integer.parseInt(r.getParameter("id_producto"));

		Producto producto = new Producto();
		
		try {
			producto = productoService.find(id_producto);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		boolean encontrado = false;
	
		if(producto != null) {
			encontrado = true;
		}
		map.put("producto", producto);
		map.put("encontrado", encontrado);
		return map;
	}
	
	
	
}
