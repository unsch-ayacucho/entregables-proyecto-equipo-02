package pe.edu.unsch.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pe.edu.unsch.model.Cliente;


@Repository("clienteDao")
public class ClienteDaoImpl implements ClienteDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void crearCuenta(Cliente cliente) {
		entityManager.persist(cliente);
		
	}

	@Override
	public Cliente loginUser(String correo, String password) {
		try {
			return (Cliente) entityManager
					.createQuery("from Cliente where correo = :correo and password = :password")
					.setParameter("correo", correo).setParameter("password", password).getSingleResult();

		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	

}
