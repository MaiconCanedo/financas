package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

public class TesteMovimentacoesComCategoria {
	
	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria("Viagens");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta(2);
		
		Movimentacao movimentacao = new Movimentacao(new BigDecimal(100.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Viagem a SP", conta, Arrays.asList(categoria1, categoria2));
		Movimentacao movimentacao2 = new Movimentacao(new BigDecimal(300.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Viagem a RJ", conta, Arrays.asList(categoria1, categoria2));
		
		
	}
}