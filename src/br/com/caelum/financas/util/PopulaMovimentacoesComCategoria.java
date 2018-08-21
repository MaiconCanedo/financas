package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss");
		
		Categoria categoria1 = new Categoria("Viagens");
		Categoria categoria2 = new Categoria("Negócios");
		Categoria categoria3 = new Categoria("Compras");
		Categoria categoria4 = new Categoria("Mecânico");
		
		Conta conta = new Conta(2);
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Calendar data1 = Calendar.getInstance();
		Calendar data2 = Calendar.getInstance();
		
		data1.setTime(dateFormat.parse("26/07/2018T12:30:10"));
		data2.setTime(dateFormat.parse("27/07/2018T15:30:10"));
		
		Movimentacao movimentacao1 = new Movimentacao(new BigDecimal(100.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Viagem a SP", new Conta(4), Arrays.asList(categoria1, categoria2));
		Movimentacao movimentacao2 = new Movimentacao(new BigDecimal(300.0), TipoMovimentacao.SAIDA, amanha, "Viagem a RJ", new Conta(4), Arrays.asList(categoria1, categoria2));
		Movimentacao movimentacao3 = new Movimentacao(new BigDecimal(80.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Restaurante", new Conta(3), Arrays.asList(categoria3));
		Movimentacao movimentacao4 = new Movimentacao(new BigDecimal(250.0), TipoMovimentacao.SAIDA, amanha, "Revisão do Gol", new Conta(3), Arrays.asList(categoria4));
		Movimentacao movimentacao5 = new Movimentacao(new BigDecimal(110.0), TipoMovimentacao.SAIDA, Calendar.getInstance(), "Supermercado", conta, Arrays.asList(categoria3));
		Movimentacao movimentacao6 = new Movimentacao(new BigDecimal(50.0), TipoMovimentacao.SAIDA, data1, "Restaurante", conta, Arrays.asList(categoria3));
		Movimentacao movimentacao7 = new Movimentacao(new BigDecimal(40.0), TipoMovimentacao.SAIDA, data1, "Restaurante", conta, Arrays.asList(categoria3));
		Movimentacao movimentacao8 = new Movimentacao(new BigDecimal(30.0), TipoMovimentacao.SAIDA, data2, "Restaurante", conta, Arrays.asList(categoria3));
		Movimentacao movimentacao9 = new Movimentacao(new BigDecimal(20.0), TipoMovimentacao.SAIDA, data2, "Restaurante", conta, Arrays.asList(categoria3));
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria1);
		entityManager.persist(categoria2);
		entityManager.persist(categoria3);
		entityManager.persist(categoria4);
		
		entityManager.persist(movimentacao1);
		entityManager.persist(movimentacao2);
		entityManager.persist(movimentacao3);
		entityManager.persist(movimentacao4);
		entityManager.persist(movimentacao5);
		entityManager.persist(movimentacao6);
		entityManager.persist(movimentacao7);
		entityManager.persist(movimentacao8);
		entityManager.persist(movimentacao9);
		
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}