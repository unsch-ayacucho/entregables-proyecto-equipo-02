package pe.edu.unsch.service;

import java.util.List;

import pe.edu.unsch.model.Producto;

public interface ProductoService {
	public Producto find(Integer id);
	public List<Producto> destacado(int n);
	public List<Producto> reciente(int n);

}
