package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria(1);
		
		Query query = entityManager.createQuery("select m from Movimentacao m join m.categorias c where c = :pCategoria");
		query.setParameter("pCategoria", categoria);
		
		@SuppressWarnings("unchecked")
		List<Movimentacao> lista = query.getResultList();
		
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	} 
}