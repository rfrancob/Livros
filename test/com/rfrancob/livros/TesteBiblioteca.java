package com.rfrancob.livros;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

public class TesteBiblioteca extends TestCase {

	private Livro l1;
	private Livro l2;
	private Pessoa p1;
	private Pessoa p2;
	private Biblioteca b1;

	//TESTE DO CONSTRUTOR
	@Test
	public void testBiblioteca() {
		Biblioteca b1 = new Biblioteca("Unicentro");
		
		assertEquals("Unicentro", b1.nome);
		
		assertTrue(b1.livros instanceof ArrayList);
		assertTrue(b1.pessoas instanceof ArrayList);
	}
	
	public void setup(){
		l1 = new Livro("Livro1");
		l2 = new Livro("Livro2");
		
		p1 = new Pessoa();
		p2 = new Pessoa();
		
		p1.setNome("Bart");
		p2.setNome("Lisa");
		
		b1 = new Biblioteca("Teste");
	}

	public void testAddLivro(){
		//cria objetos
		setup();
		
		//testa se a biblioteca está vazia
		assertEquals(0, b1.getLivros().size());
		
		b1.addLivro(l1);
		b1.addLivro(l2);
		
		assertEquals(2, b1.getLivros().size());
		assertEquals(0, b1.getLivros().indexOf(l1));
		assertEquals(1, b1.getLivros().indexOf(l2));
		
		b1.removeLivro(l1);
		
		assertEquals(1, b1.getLivros().size());
		assertEquals(0, b1.getLivros().indexOf(l2));
		
		b1.removeLivro(l2);
		assertEquals(0, b1.getLivros().size());
	}
	
	public void testEmprestimo(){
		//add os objetos
		setup();
		
		addItens();
		
		assertTrue("Livro não pode ser emprestado", b1.emprestimo(l1,p1));
		
		assertEquals("Bart", l1.getPessoa().getNome());
		
		assertFalse("Livro já foi emprestado", b1.emprestimo(l1,p2));
		
		assertTrue("Devolução de livro falhou", b1.devolucao(l1));
		
		assertFalse("Já foi feita a devolução", b1.devolucao(l1));
		
		assertFalse("Livro nunca foi emprestado", b1.devolucao(l1));
		
		//teste adiconal para maximo livros
		setup();
		p1.setMaxLivros(1);
		addItens();
		
		assertTrue("Primeiro ivro não pode ser emprestado", b1.emprestimo(l2, p1));
		assertFalse("Segundo livro não deveria ser emprestado", b1.emprestimo(l1, p1));
	}
	
	public void testGetLivrosPorPessoa(){
		setup();
		addItens();
		
		assertEquals(0, b1.getLivrosPorPessoa(p1).size());
		
		b1.emprestimo(l1, p1);
		
		ArrayList<Livro> testeLivros = b1.getLivrosPorPessoa(p1);
		assertEquals(1,testeLivros.size());
		assertEquals(0, testeLivros.indexOf(l1));
		
		b1.emprestimo(l2, p1);
		
		testeLivros = b1.getLivrosPorPessoa(p1);
		assertEquals(2, testeLivros.size());
		assertEquals(1, testeLivros.indexOf(l2));
	}

	private void addItens() {
		b1.addLivro(l1);
		b1.addLivro(l2);
		b1.addPessoa(p1);
		b1.addPessoa(p2);
	}
	public void testGetLivrosDisponiveis() {
		setup();
		addItens();
		
		ArrayList<Livro> testeLivros = b1.getLivrosDisponiveis();
		assertEquals(0,testeLivros.size());
		assertEquals(-1, testeLivros.indexOf(l2));
		
		b1.emprestimo(l1, p1);
		testeLivros = b1.getLivrosDisponiveis();
		assertEquals(1, testeLivros.size());
		assertEquals(-1, testeLivros.indexOf(l2));
		
		b1.emprestimo(l2, p1);
		testeLivros = b1.getLivrosDisponiveis();
		assertEquals(2, testeLivros.size());
		
	}
}
