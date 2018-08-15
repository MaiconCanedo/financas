package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta("Leonardo", "45620", "Caixa", "054");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}
}
