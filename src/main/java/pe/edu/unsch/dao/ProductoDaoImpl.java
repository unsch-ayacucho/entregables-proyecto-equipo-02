package pe.edu.unsch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.model.Producto;

@Repository("productoDao")
public class ProductoDaoImpl implements ProductoDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Producto find(Integer id) {
		
		return (Producto) entityManager.find(Producto.class, id);
	}

}
