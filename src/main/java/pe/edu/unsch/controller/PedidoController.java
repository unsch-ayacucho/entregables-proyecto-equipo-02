package pe.edu.unsch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.unsch.model.Cliente;
import pe.edu.unsch.model.Pedido;
import pe.edu.unsch.service.PedidoService;

@Controller
@RequestMapping("/orders")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping
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

}
