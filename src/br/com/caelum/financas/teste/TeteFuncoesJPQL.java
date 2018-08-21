package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TeteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta(2);
		
		Query query = entityManager.createQuery("SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo"
				+ " group by day(m.data), month(m.data), year(m.data)");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		@SuppressWarnings("unchecked")
		List<Double> medias = query.getResultList();
		System.out.println("Médias: " + medias);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}