package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagens");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta(2);
		
		Movimentacao movimentacao = new Movimentacao(new BigDecimal(100.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Viagem a SP", conta, Arrays.asList(categoria1, categoria2));
		Movimentacao movimentacao2 = new Movimentacao(new BigDecimal(300.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Viagem a RJ", conta, Arrays.asList(categoria1, categoria2));
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria1);
		entityManager.persist(categoria2);
		
		entityManager.persist(movimentacao);
		entityManager.persist(movimentacao2);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}