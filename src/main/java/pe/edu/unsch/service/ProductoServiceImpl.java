package pe.edu.unsch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.ProductoDao;
import pe.edu.unsch.model.Producto;

@Transactional
@Service("productoService")
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDao productoDao;

	@Override
	public Producto find(Integer id) {
		return productoDao.find(id);
	}

	@Override
	public List<Producto> destacado(int n) {
		return productoDao.destacado(n);
	}

	@Override
	public List<Producto> reciente(int n) {
		return productoDao.destacado(n);
	}

}
