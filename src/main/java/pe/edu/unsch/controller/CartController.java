package pe.edu.unsch.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.unsch.model.Cliente;
import pe.edu.unsch.model.Detalle_Pedido;
import pe.edu.unsch.model.Item;
import pe.edu.unsch.model.Pedido;
import pe.edu.unsch.service.DetallePedidoService;
import pe.edu.unsch.service.PedidoService;
import pe.edu.unsch.service.ProductoService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private ProductoService productoService;

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private DetallePedidoService detallePedidoService;

	@GetMapping
	public String cart(Model model, HttpSession session) {
		
		/*de aqui*/
		String correo = "Sin sesión";
		
		if(session.getAttribute("user_login") != null) {
			correo = (String) session.getAttribute("user_login");
		}
		model.addAttribute("user_login", correo);
		System.out.println(correo);
		/*hasta aca*/
		
		
		
		return "views/public/Cart/cart";
	}
	
	@GetMapping("/buy/{id}")
	public String add(@PathVariable("id") int id, HttpSession session, Model model) {
		
		
		if (session.getAttribute("cart") == null) {
			List<Item> cart = new ArrayList<Item>();
			cart.add(new Item(productoService.find(id), 1));
			session.setAttribute("cart", cart);
		} else {
			List<Item> cart = (List<Item>) session.getAttribute("cart");
			int index = isEXists(id, session);
			
			if(index == -1) {
				cart.add(new Item(productoService.find(id), 1));
			} else {
				int cantidad = cart.get(index).getCantidad() + 1;
				cart.get(index).setCantidad(cantidad);
				session.setAttribute("cart", cart); 
			}
			session.setAttribute("cart", cart);
		}
		
		return "views/public/Cart/cart";
	}
	
	@GetMapping("delete/{index}")
	public String delete(@PathVariable("cart") int index, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/cart";
	}

	private int isEXists(int id, HttpSession session) {
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getProducto().getId_producto() == id) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> checkout(HttpSession session, @RequestBody String jsonData) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject obj = new JSONObject(jsonData);
		
		JSONArray arr = obj.getJSONArray("items_carrito");
		
		Pedido pedido = new Pedido();
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		System.out.println(cliente);
		
		pedido.setFecha(new Date());	
		pedido.setCliente(cliente);
		pedido.setEstado_pedido("En espera");
		
		Pedido newPedido = pedidoService.crearPedido(pedido);
		//System.out.println(newPedido.getId_pedido());
		boolean registrado = false;	
		for (int i = 0; i < arr.length(); i++) {
        	int id_producto = arr.getJSONObject(i).getInt("id_producto"); 
        	int cantidad = arr.getJSONObject(i).getInt("cantidad"); 
            Double precio = arr.getJSONObject(i).getDouble("precio"); 
            
            Detalle_Pedido dp = new Detalle_Pedido();
            dp.setCantidad(cantidad);
            dp.setProducto(productoService.find(id_producto));
            dp.setPrecio(precio*cantidad);
            dp.setPedido(newPedido);
            
            detallePedidoService.crearDetalle(dp);
            registrado = true;
        }
		
		map.put("registrado", registrado);
		return map;
	}
}
