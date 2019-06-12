package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.CategoriaDao;
import app.model.Categoria;

@Service("categoriaService")
@Transactional(readOnly = true)
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> findAll(){
		return categoriaDao.findAll();
	}
}
