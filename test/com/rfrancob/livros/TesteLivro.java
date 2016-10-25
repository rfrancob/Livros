package com.rfrancob.livros;

import org.junit.Test;

import junit.framework.TestCase;

public class TesteLivro extends TestCase {

	@Test
	public void testLivro() {

		Livro l1 = new Livro("Game Of Thrones");
		assertEquals("Game Of Thrones", l1.titulo);
		assertEquals("Autor desconhecido", l1.autor);
	}
	
	@Test
	public void testGetPessoa(){
	Livro l2 = new Livro("Senhor dos Aneis");
	Pessoa p2 = new Pessoa();
	p2.setNome("Presley");
	
	//Metodo para dizer que este livro está com está pessoa
	l2.setPessoa(p2);
	
	//Pegar o nome da pessoa que está como o livro
	/*Pessoa testPessoa = l2.getPessoa();
	String testNome = testPessoa.getNome();*/
	String testNome = l2.getPessoa().getNome();
	assertEquals("Presley", testNome);
	}
}
