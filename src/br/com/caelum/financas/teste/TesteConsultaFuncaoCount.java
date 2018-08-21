package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		query.setParameter("pConta", new Conta(2));
		
		Long quantidadeDeMovimentacoes = (Long) query.getSingleResult();
		System.out.println("Quantidade de Movimentações: " + quantidadeDeMovimentacoes);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}