package com.rfrancob.livros;

import org.junit.Test;

import junit.framework.TestCase;

public class TestePessoa extends TestCase {

	@Test
	public void testPessoa() {
		Pessoa p1 = new Pessoa();
		assertEquals("Nome Desconhecido", p1.getNome());
		assertEquals(3, p1.getMaxLivros());
	}

	@Test
	public void testSetNome() {
		Pessoa p2 = new Pessoa();
		p2.setNome("Raphael Franco");
		assertEquals("Raphael Franco", p2.getNome());
	}

	@Test
	public void testSetMaxLivros() {
		Pessoa p3 = new Pessoa();
		p3.setMaxLivros(10);
		assertEquals(10, p3.getMaxLivros());
	}
	
	public void testToString() {
		Pessoa p4 = new Pessoa();
		p4.setNome("Raphael Franco Borges");
		p4.setMaxLivros(7);
		String teste = "Raphael Franco Borges tem 7 livros";
		assertEquals(teste, p4.toString());
	}
}
