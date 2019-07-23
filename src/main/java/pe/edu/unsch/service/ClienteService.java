package pe.edu.unsch.service;

import pe.edu.unsch.model.Cliente;

public interface ClienteService {
	public void crearCuenta(Cliente cliente);
	Cliente loginUser(String correo, String password);

}
