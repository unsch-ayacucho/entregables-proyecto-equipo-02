package pe.edu.unsch.dao;

import java.util.List;

import pe.edu.unsch.model.Producto;

public interface ProductoDao {
	
	public Producto find(Integer id);
	public List<Producto> destacado(int n);
	public List<Producto> reciente(int n);

}
