package com.rfrancob.livros;

public class Livro {

	String titulo;
	String autor;
	Pessoa pessoa;

	public Livro(String string) {
		this.titulo = string;
		this.autor = "Autor desconhecido";
	}

	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setPessoa(Pessoa p2) {
		this.pessoa = p2;		
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}	
}
