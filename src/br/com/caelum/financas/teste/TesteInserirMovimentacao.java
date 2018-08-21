package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
        
        Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();
        
        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }
        
        em.close();
    }
}