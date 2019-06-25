package pe.edu.unsch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.CategoriaDao;
import pe.edu.unsch.model.Categoria;

@Service("categoriaService")
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll(){
		return categoriaDao.findAll();
	}

	@Override
	public Categoria find(Integer id) {
		return categoriaDao.find(id);
	}
}
