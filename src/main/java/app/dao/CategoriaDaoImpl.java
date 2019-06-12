package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import app.model.Categoria;

@Repository("categoriaDao")
public class CategoriaDaoImpl implements CategoriaDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Categoria>findAll() {
		return entityManager
				.createQuery("from Categoria where subcategoria = 0", Categoria.class)
				.getResultList();
		
	}

}
