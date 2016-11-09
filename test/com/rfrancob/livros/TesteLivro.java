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
	
	//Metodo para dizer que este livro est� com est� pessoa
	l2.setPessoa(p2);
	
	//Pegar o nome da pessoa que est� como o livro
	/*Pessoa testPessoa = l2.getPessoa();
	String testNome = testPessoa.getNome();*/
	String testNome = l2.getPessoa().getNome();
	assertEquals("Presley", testNome);
	}
	
	public void testToString() {
		Livro l2 = new Livro("Guerra e Paz");
		Pessoa p2 = new Pessoa();
		p2.setNome("Elvis");
		
		assertEquals("Guerra e Paz por Autor desconhecido; Dispon�vel.", l2.toString()); 
		
		l2.setPessoa(p2);
		
		assertEquals("Guerra e Paz por Autor desconhecido; Emprestado para Elvis", l2.toString());
	}
}
