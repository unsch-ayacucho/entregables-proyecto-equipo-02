package pe.edu.unsch.dao;
import pe.edu.unsch.model.Cliente;

public interface ClienteDao{
	public void crearCuenta(Cliente cliente);
	Cliente loginUser(String correo, String password);
}
