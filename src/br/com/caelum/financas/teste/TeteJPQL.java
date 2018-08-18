package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TeteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Conta conta = new Conta(2);
		
		Query query = entityManager.createQuery("SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo order by m.valor desc");
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> lista = query.getResultList();
		
		
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao);
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}