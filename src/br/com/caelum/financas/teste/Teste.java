package br.com.caelum.financas.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Teste {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse("26/07/2018 12:30:10"));
		System.out.println(dateFormat.format(calendar.getTime()));
	}

}
