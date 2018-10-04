package br.com.redmonkeysoftware.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.redmonkeysoftware.entidade.Cliente;
import br.com.redmonkeysoftware.persistencia.GerenciaCliente;

@ManagedBean
@SessionScoped
public class ClienteBean {
	
	Cliente cliente;
	List<Cliente>clientes;
	GerenciaCliente gerenciaCliente;

	public ClienteBean() {
		gerenciaCliente = new GerenciaCliente();
		cliente = new Cliente(); 
	}
 public String salvar() {
	 gerenciaCliente.salvarCliente(cliente);
	 return "index";	
 }
 
 public String editar() {
	 return "formulario";
 }
 public String remover() {
	 gerenciaCliente.removerCliente(cliente);
	 return null;
 }
 
 public String novo() {
	 cliente = new Cliente();
	 return "formulario" ;
 }
	
	public List<Cliente> getClientes() {
		clientes = gerenciaCliente.listarTodos();
		return clientes;
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
