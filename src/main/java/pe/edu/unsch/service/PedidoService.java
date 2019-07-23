package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.model.Pedido;

public interface PedidoService {
	public List<Pedido> listarPedidos(int id_cliente);
	public Pedido crearPedido(Pedido pedidos);
}
