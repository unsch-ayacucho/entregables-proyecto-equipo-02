package pe.edu.unsch.dao;

import java.util.List;

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

	@Override
	public List<Producto> destacado(int n) {
		return entityManager.createQuery("from Producto where destacado =: destacado order by id desc", Producto.class)
				.setParameter("destacado", (byte)1)
				.setMaxResults(n)
				.getResultList();
	}

	@Override
	public List<Producto> reciente(int n) {
		return entityManager.createQuery("from Producto order by id desc", Producto.class)
				.setMaxResults(n)
				.getResultList();
	}

}
