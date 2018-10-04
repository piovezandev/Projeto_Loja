package br.com.redmonkeysoftware.interfaces;
/*Piovezandev_*/
import java.util.List;

import br.com.redmonkeysoftware.entidade.Cliente;

public interface CadastroCliente {
	
	public void salvarCliente(Cliente cliente);
	public void removerCliente(Cliente cliente);
	public List<Cliente> listarTodos();
	public Cliente buscarPorId(int id);

}
