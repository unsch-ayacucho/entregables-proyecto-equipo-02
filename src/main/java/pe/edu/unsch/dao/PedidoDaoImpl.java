package pe.edu.unsch.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.model.Pedido;

@Repository("pedidoDao")
public class PedidoDaoImpl implements PedidoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Pedido> listarPedidos(int id_cliente) {
		return entityManager.createNativeQuery("select * from pedido where id_cliente =:id_cliente", Pedido.class)
				.setParameter("id_cliente", id_cliente).getResultList();
	}

	@Override
	public Pedido crearPedido(Pedido pedidos) {
		entityManager.persist(pedidos);
		return pedidos;
	}

}
