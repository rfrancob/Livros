package com.rfrancob.livros;

public class Pessoa {
	//ATRIBUTOS
	private String nome;
	private int maxLivros;//QUANTIDADE MÁXIMA DE LIVROS POR PESSOA

	//CONSTRUTORES
	public Pessoa(){
		nome = "Nome Desconhecido";
		maxLivros = 3;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMaxLivros() {
		return maxLivros;
	}
	public void setMaxLivros(int maxLivros) {
		this.maxLivros = maxLivros;
	}
	
	public String toString() {
		return this.getNome() + " tem " + this.getMaxLivros() + " livros";
	}
}
