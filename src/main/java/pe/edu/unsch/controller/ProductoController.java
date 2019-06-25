package pe.edu.unsch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.model.Categoria;
import pe.edu.unsch.model.Producto;
import pe.edu.unsch.service.CategoriaService;
import pe.edu.unsch.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	@Autowired
	CategoriaService categoriaService;

	@Autowired
	ProductoService productoService;

	@GetMapping("/categoria/{id}")
	public String categoria(@PathVariable("id") Integer id, Model model) {
		Categoria categoria = categoriaService.find(id);

		List<Producto> productos = new ArrayList<>();

		try {
			productos = categoria.getProducto();
			for(Producto p : productos) {
				System.out.println(p.getNombre());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}



		model.addAttribute("productos", productos);
		return "views/public/producto/categoria";

	}
	
	@RequestMapping(value = "/categoria/verCategoria", method = RequestMethod.POST)
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
	

	@GetMapping("detalle/{id}")
	public String detalle(@PathVariable("id") Integer id, Model model) {

		Producto producto = new Producto();

		try {
			producto = productoService.find(id);
			System.out.println(producto.getNombre());
			System.out.println(producto.getDescripcion());

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("producto", producto);

		return "views/public/producto/categoria";
	}

}
