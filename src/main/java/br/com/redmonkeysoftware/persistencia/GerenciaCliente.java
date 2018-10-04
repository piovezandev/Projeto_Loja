package br.com.redmonkeysoftware.persistencia;
/*Piovezandev_*/
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.redmonkeysoftware.entidade.Cliente;
import br.com.redmonkeysoftware.interfaces.CadastroCliente;

public class GerenciaCliente implements CadastroCliente{

	EntityManagerFactory emf;
	EntityManager em;
	
	public GerenciaCliente() {
	emf = 	Persistence.createEntityManagerFactory("projetoloja");
	em = emf.createEntityManager();	  
	}
	
	@Override
	public void salvarCliente(Cliente cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}

	@Override
	public void removerCliente(Cliente cliente) {
		em.getTransaction().begin();
		em.remove(cliente);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listarTodos(){
		em.getTransaction().begin();
		Query consulta = em.createQuery("select cliente from Cliente cliente");
		List<Cliente> clientes = consulta.getResultList();
		em.getTransaction().commit();
		return clientes;
	}

	@Override
	public Cliente buscarPorId(int id) {
		em.getTransaction().begin();
		Cliente cliente = em.find(Cliente.class, id);
		em.getTransaction().commit();
		return cliente;
	}

}
