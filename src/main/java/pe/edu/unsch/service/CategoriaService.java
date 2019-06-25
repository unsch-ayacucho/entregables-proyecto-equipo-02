package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.model.Categoria;

public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria find(Integer id);

}
