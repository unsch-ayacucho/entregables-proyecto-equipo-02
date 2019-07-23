package pe.edu.unsch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.unsch.dao.ClienteDao;
import pe.edu.unsch.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteDao clienteDao;

	@Override
	public void crearCuenta(Cliente cliente) {
		clienteDao.crearCuenta(cliente);;
		
	}

	@Override
	public Cliente loginUser(String correo, String password) {
		// TODO Auto-generated method stub
		return clienteDao.loginUser(correo, password);
	}

	/*@Override
	public Cliente login(String correo, String password) {
		// TODO Auto-generated method stub
		return clienteDao.login(correo, password);
	}*/

	

}
