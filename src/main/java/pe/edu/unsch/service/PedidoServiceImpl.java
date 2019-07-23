package pe.edu.unsch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.PedidoDao;
import pe.edu.unsch.model.Pedido;


@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoDao pedidoDao;

	@Override
	public List<Pedido> listarPedidos(int id_cliente) {
		return pedidoDao.listarPedidos(id_cliente);
	}

	@Override
	public Pedido crearPedido(Pedido pedidos) {
		// TODO Auto-generated method stub
		return pedidoDao.crearPedido(pedidos);
	}
}
