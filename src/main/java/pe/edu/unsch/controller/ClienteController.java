package pe.edu.unsch.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.unsch.model.Cliente;
import pe.edu.unsch.model.Pedido;
import pe.edu.unsch.service.ClienteService;
import pe.edu.unsch.service.PedidoService;

@Controller
@RequestMapping("/account")
public class ClienteController {

	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("account", new Cliente());
		return "views/public/cliente/registrar";
	}
	
	@GetMapping("/footer")
	public String footer(Model model) {
		return "views/public/about/about";
	}
	
	@GetMapping("/contact")
	public String contact(Model model) {
		model.addAttribute("titulo", "Cart : e-commerce");
		return "views/public/about/contact";
	}

	
	@GetMapping("/customerorders")
	public String order(Model model, HttpSession session) {

		Cliente cliente = (Cliente) session.getAttribute("cliente");

		List<Pedido> pedidos = new ArrayList<>();
		
		if (cliente != null) {
			int id_cliente = cliente.getId_cliente();
			pedidos = pedidoService.listarPedidos(id_cliente);
			model.addAttribute("pedidos", pedidos);
			model.addAttribute("cliente", cliente);
			return "views/public/cliente/orders";
		} else {
			return "login";
		}
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("account") Cliente cliente, RedirectAttributes redir) {
		redir.addAttribute("titulo", "New account : e-commerce");
		System.out.println("prueba account: " + cliente.getCorreo());
		
		try {
			clienteService.crearCuenta(cliente);
			redir.addFlashAttribute("message", "La cuenta fue creada correctamente");
			return "redirect:/account/register";
		} catch (Exception e) {
			redir.addFlashAttribute("message", "No puede registrar nueva cuenta");
			return "redirect:/account/register";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getResponsable(HttpServletRequest r, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String correo = r.getParameter("email");
		String password = r.getParameter("password");
		
		System.out.println("aqui es la primera impression " +" "+ correo + " "+password);
		
		Cliente cliente = new Cliente();
		boolean isLogin = false;
		
		try {
			cliente = clienteService.loginUser(correo, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(cliente != null) {
			isLogin = true;
			session.setAttribute("user_login", cliente.getCorreo());
			
			//Cliente cliente = usuario.getCliente();
			session.setAttribute("cliente", cliente);
		} 
		
		System.out.println(cliente);
		map.put("isLogin", isLogin);
		return map;
	}

	
	@GetMapping("/logout") 
	public String logout(HttpSession session) {  
		session.removeAttribute("email");  
		session.removeAttribute("user_login"); 
		return "redirect:/account/register"; 
	}
}
