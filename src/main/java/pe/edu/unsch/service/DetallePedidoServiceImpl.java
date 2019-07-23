package pe.edu.unsch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.DetallePedidoDao;
import pe.edu.unsch.model.Detalle_Pedido;

@Service
@Transactional
public class DetallePedidoServiceImpl implements DetallePedidoService{
	
	@Autowired
	DetallePedidoDao detallePedidoDao;

	@Override
	public void crearDetalle(Detalle_Pedido detalles_pedidos) {
		detallePedidoDao.crearDetalle(detalles_pedidos);
		
	}

}
