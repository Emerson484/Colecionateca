
package model;

import java.io.Serializable;
//classe que vai servir de modelo para suas subclasses

public class Livro implements Serializable {
    //atributos gerais para a classe Livro e suas subclasses
    private String titulo;
    private String autor;
    private String isbn;
    private int ano;
    private int progresso;

    //Construtor para o objeto da classe livro
    public Livro(String titulo, String autor, String isbn, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
        this.progresso = 0;
    }

    //métodos get e set para todos os atributos
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getProgresso() { return progresso; }
    public void setProgresso(int progresso) { this.progresso = progresso; }

    //método que retorna os dados do Livro
    @Override
    public String toString() {
        return "Livro: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Ano: " + ano + ", página " + progresso;
    }
}
