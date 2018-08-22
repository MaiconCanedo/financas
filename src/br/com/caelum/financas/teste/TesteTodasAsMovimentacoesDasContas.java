package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

	public static void main(String[] args) {
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		
		entityManager.getTransaction().begin();
		
		TypedQuery<Conta> query = entityManager.createQuery("SELECT distinct c FROM Conta c left join fetch c.movimentacoes", Conta.class);

		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular() + ", Conta.id: " + conta.getId() + "\nMovimentacoes:");
			for (Movimentacao movimentacao : conta.getMovimentacoes()) {
				System.out.println(movimentacao);
			}
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}