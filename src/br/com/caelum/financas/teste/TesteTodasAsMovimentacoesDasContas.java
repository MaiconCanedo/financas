package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		Query query = entityManager.createQuery("SELECT c FROM Conta c join fetch c.movimentacoes");
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular() + "\nMovimentacoes:");
			for (Movimentacao movimentacao : conta.getMovimentacoes()) {
				System.out.println(movimentacao);
			}
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}