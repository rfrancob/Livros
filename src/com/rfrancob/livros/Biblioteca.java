package com.rfrancob.livros;

import java.util.ArrayList;

public class Biblioteca {

	String nome;
	ArrayList<Livro> livros;
	ArrayList<Pessoa> pessoas;

	public Biblioteca(String nome) {
		this.nome = nome;
		
		livros = new ArrayList<Livro>();
		pessoas = new ArrayList<Pessoa>();
		
	}

	public String getNome() {
		return nome;
	}

	public ArrayList<Livro> getLivros() {
		return livros;
	}

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void addLivro(Livro l1) {
		this.livros.add(l1);
	}

	public void removeLivro(Livro l1) {
		this.livros.remove(l1);
		
	}
	
	public void addPessoa(Pessoa p1){
		this.pessoas.add(p1);
	}
	
	public void removePessoa(Pessoa p1){
		this.pessoas.remove(p1);
	}

	public boolean emprestimo(Livro l1, Pessoa p1) {
		int livrosEmprestados = this.getLivrosPorPessoa(p1).size();
		if((l1.getPessoa() == null) && (livrosEmprestados < p1.getMaxLivros())){
			l1.setPessoa(p1);
			return true;
		}
		else{
			return false;
		}
	}

	public boolean devolucao(Livro l1) {
		if(l1.getPessoa() != null){
			l1.setPessoa(null);
			return true;
		}
		else {
			return false;
		}
	}

	public ArrayList<Livro> getLivrosPorPessoa(Pessoa p1) {
		ArrayList<Livro> resultado = new ArrayList<Livro>();
		
		for(Livro umLivro : this.getLivros()){
			if((umLivro.getPessoa() != null) && (umLivro.getPessoa().getNome().equals(p1.getNome()))){
				resultado.add(umLivro);
			}
		}
		return resultado;
	}

	public ArrayList<Livro> getLivrosDisponiveis() {
		ArrayList<Livro> resultado = new ArrayList<Livro>();
		
		for(Livro umLivro : this.getLivros()){
			if(umLivro.getPessoa() != null){
				resultado.add(umLivro);
			}
		}
		return resultado;
	}
	
	public static void main(String[] args) {
		
		//Cria uma nova biblioteca
		Biblioteca testeBiblioteca = new Biblioteca("Raphael");
		Livro l1 = new Livro("O príncipe e o pobre");
		l1.setAutor("Mark Twain");
		Livro l2 = new Livro("O livro dos cinco elementos");
		l2.setAutor("Myamoto Musashi");
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Lisa Simpson");
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Bart Simpson");
		
		testeBiblioteca.addLivro(l1);
		testeBiblioteca.addLivro(l2);
		
		testeBiblioteca.addPessoa(p1);
		testeBiblioteca.addPessoa(p2);
		
		System.out.println("Criada a nova Biblioteca!");
		testeBiblioteca.imprimeStatus();
		
		testeBiblioteca.emprestimo(l1, p1);
		
		System.out.println("Emprestado O príncipe e o pobre para Lisa Simpson");
		testeBiblioteca.imprimeStatus();
		
		System.out.println("Faz mais alguma coisa");
		testeBiblioteca.devolucao(l1);
		
		testeBiblioteca.emprestimo(l2, p2);
		testeBiblioteca.imprimeStatus();
	}

	private void imprimeStatus() {
		System.out.println("Status da minha Biblioteca \n" + this.toString());
		
		for (Livro umLivro : this.getLivros()) {
			System.out.println(umLivro);
		}
		
		for (Pessoa umaPessoa : this.getPessoas()) {
			int contador = this.getLivrosPorPessoa(umaPessoa).size();
			System.out.println(umaPessoa + " tem " + contador + " dos meus livros");
		}
		
		System.out.println("Livros disponíveis: " + this.getLivrosDisponiveis().size());
		
		System.out.println("--- Fim do Status ---");
	}
}
