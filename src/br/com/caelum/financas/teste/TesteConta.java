package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta(1, "Leonardo", "45620", "Caixa", "054");
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(conta);
		conta.setBanco("Bradesco");
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}