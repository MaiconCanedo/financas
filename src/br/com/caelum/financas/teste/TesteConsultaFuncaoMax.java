package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsultaFuncaoMax {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(entityManager);
		BigDecimal valorMaximo = movimentacaoDao.getValorMaximo(new Conta(2));
		
		System.out.println("Varlor máximo de Movimentacao: " + valorMaximo);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}