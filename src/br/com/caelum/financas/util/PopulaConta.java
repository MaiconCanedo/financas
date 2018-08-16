package br.com.caelum.financas.util;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class PopulaConta {
	
	public static void main(String[] args) {
		Conta conta1 = new Conta("João", "46014", "Bradesco", "012");
		Conta conta2 = new Conta("Maicon", "46021", "Caixa", "023");
		Conta conta3 = new Conta("Marcos", "43011", "Banco do Brasil", "0446");
		Conta conta4 = new Conta("Samuel", "41350", "Bradesco", "021");
		Conta conta5 = new Conta("Jonatas", "41256", "Bradesco", "055");
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta1);
		entityManager.persist(conta2);
		entityManager.persist(conta3);
		entityManager.persist(conta4);
		entityManager.persist(conta5);
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}