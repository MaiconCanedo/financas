package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TeteContaCliente {
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Leonardo", "Professor", "Rua José de Alencar, 110", new Conta(2));
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(cliente);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}