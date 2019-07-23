package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.model.Pedido;


public interface PedidoDao {
	public List<Pedido> listarPedidos(int id_cliente);
	public Pedido crearPedido(Pedido pedidos);
}
