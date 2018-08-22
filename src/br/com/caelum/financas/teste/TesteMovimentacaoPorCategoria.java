package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Categoria categoria = new Categoria(1);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		List<Movimentacao> lista = movimentacaoDao.getMovimentacaoPorCategoria(categoria);
		
		for (Movimentacao movimentacao : lista) {
			System.out.println(movimentacao);
		}
		
		entityManager.getTransaction().commit();
		entityManager.close();
	} 
}