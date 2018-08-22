package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TeteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta(2);
		
		MovimentacaoDao dao = new MovimentacaoDao(entityManager);
		
		List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		System.out.println("Média do dia 22: " + medias);

		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}