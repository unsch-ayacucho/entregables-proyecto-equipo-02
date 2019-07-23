package pe.edu.unsch.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.edu.unsch.model.Detalle_Pedido;
@Repository("detallePedidoDao")
public class DetallePedidoDaoImpl implements DetallePedidoDao{

	
	@Autowired
	private EntityManager entityManager;

	@Override
	public void crearDetalle(Detalle_Pedido detalles_pedidos) {
		entityManager.persist(detalles_pedidos);
		
	}

}
