package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<BigDecimal> query = entityManager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		query.setParameter("pConta", new Conta(2));
		BigDecimal valorMax = query.getSingleResult();
		
		System.out.println("Varlor máximo de Movimentacao: " + valorMax);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}