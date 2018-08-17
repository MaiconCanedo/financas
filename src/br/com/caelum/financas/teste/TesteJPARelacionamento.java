package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		Conta conta = new Conta("Leonardo", "458785", "Bradesco", "0124");
		Movimentacao movimentacao = new Movimentacao(new BigDecimal(200.00), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Churracaria", conta, null);
				
		entityManager.getTransaction().begin();
		
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}		
}