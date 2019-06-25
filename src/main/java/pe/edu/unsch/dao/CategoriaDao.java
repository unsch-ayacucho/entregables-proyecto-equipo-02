package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.model.Categoria;

public interface CategoriaDao {

	public List<Categoria> findAll();
	public Categoria find(Integer id);

}
