package br.com.caelum.financas.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {
	
	private EntityManager entityManager;
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	public MovimentacaoDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\
	
	public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipo, Conta conta) {
		TypedQuery<Double> typeQuery = entityManager.createNamedQuery("MediasPorDiaETipo", Double.class);
		typeQuery.setParameter("pConta", conta);
		typeQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		return typeQuery.getResultList();
	}

	public Long getQuantidadeDeMovimentacoes(Conta conta) {
		TypedQuery<Long> query = entityManager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class);
		query.setParameter("pConta", conta);
		
		return query.getSingleResult();
	}

	public BigDecimal getValorMaximo(Conta conta) {
		TypedQuery<BigDecimal> query = entityManager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
		query.setParameter("pConta", new Conta(2));
		 
		return query.getSingleResult();
	}

	public List<Movimentacao> getMovimentacaoPorCategoria(Categoria categoria) {
		TypedQuery<Movimentacao> query = entityManager.createQuery("select m from Movimentacao m join m.categorias c where c = :pCategoria", Movimentacao.class);
		query.setParameter("pCategoria", categoria);
		
		return query.getResultList();
	}
	
}