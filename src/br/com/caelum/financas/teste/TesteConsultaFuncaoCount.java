package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoCount {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		MovimentacaoDao dao = new MovimentacaoDao(entityManager);
		Long quantidadeDeMovimentacoes = dao.getQuantidadeDeMovimentacoes(new Conta(2));
		System.out.println("Quantidade de Movimentações: " + quantidadeDeMovimentacoes);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}