package com.rfrancob.livros;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class TesteBiblioteca extends TestCase {

	//TESTE DO CONSTRUTOR
	@Test
	public void testBiblioteca() {
		Biblioteca b1 = new Biblioteca("Unicentro");
		
		assertEquals("Unicentro", b1.nome);
		
		assertTrue(b1.livros instanceof ArrayList);
		assertTrue(b1.pessoas instanceof ArrayList);
	}

}
