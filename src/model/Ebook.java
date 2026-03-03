package model;

import java.io.Serializable;

public class Ebook extends Livro implements Serializable {
    private static final long serialVersionUID = 1L; //// Um identificador de versão para a serialização, garante que versões diferentes da classe sejam compatíveis
    //atributos específicos da classe ebook
    private double tamanhoMB;
    private String formato;

    //construtor que reaproveita o construtor da classe mãe e adiciona os atributos específicos dessa classe
    public Ebook(String titulo, String autor, String isbn, int ano, double tamanhoMB, String formato) {
        super(titulo, autor, isbn, ano);
        this.tamanhoMB = tamanhoMB;
        this.formato = formato;
    }

    // Getters e Setters para os atributos de Ebook
    public double getTamanhoMB() { return tamanhoMB; }
    public void setTamanhoMB(double tamanhoMB) { this.tamanhoMB = tamanhoMB; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    //método sobrescrito da classe mãe para retornar os dados do ebook agora
    @Override
    public String toString() {
        // O progresso aqui pode ser interpretado como porcentagem diretamente.
        return super.toString() + ", Tamanho: " + tamanhoMB + "MB, Formato: " + formato + ", Progresso: " + getProgresso() + "%";
    }
}
