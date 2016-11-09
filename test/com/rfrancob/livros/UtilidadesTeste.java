package com.rfrancob.livros;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.*;

import junit.framework.AssertionFailedError;

public class UtilidadesTeste {

	@Test
	public void salvarStringParaArquivo(){

		String stringSalva = "Est� � a Primeira linha\n" + "Est� � a Segunda Linha\n";
		File arquivoTeste = new File("stingsalvanoarquivo.txt");
		arquivoTeste.delete();

		assertFalse("Arquivo deveria n�o existir", arquivoTeste.exists());

		assertTrue("Arquivo n�o deveria ser salvo", Utilidades.salvaStringnoArquivo("stringsalvanoarquivo.txt"));

		String novaString = Utilidades.getStringDoArquivo("stringsalvanoarquivo.txt");
		
		assertTrue("As strings deveriam ser iguais", stringSalva.equals(novaString));
		
		
	}
}
