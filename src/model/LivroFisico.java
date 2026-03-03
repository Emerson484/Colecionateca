package model;

import java.io.Serializable;

public class LivroFisico extends Livro implements Serializable {
    private static final long serialVersionUID = 1L; // Um identificador de versão para a serialização, garante que versões diferentes da classe sejam compatíveis
    //atributos específicos de LivroFísico
    private int numeroDePaginas;
    private String localizacao; // Ex: "Estante 3, Prateleira 2"

    //construtor que reaproveita o construtor da classe mãe e adiciona os atributos específicos dessa classe
    public LivroFisico(String titulo, String autor, String isbn, int ano, int numeroDePaginas, String localizacao) {
        super(titulo, autor, isbn, ano);
        this.numeroDePaginas = numeroDePaginas;
        this.localizacao = localizacao;
    }

    //get e set para os atributos específicos
    public int getNumeroDePaginas() { return numeroDePaginas; }
    public void setNumeroDePaginas(int numeroDePaginas) { this.numeroDePaginas = numeroDePaginas; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    //método que calcula a porcentagem do progresso de leitura
    public double getProgressoPercentual() {
        if (numeroDePaginas == 0) {
            return 0;
        }
        // getProgresso() aqui representa a página atual
        return (double) getProgresso() / numeroDePaginas * 100;
    }

    //método sobrescrito da classe mãe para retornar os dados do livro físico agora
    @Override
    public String toString() {
        return super.toString() + ", Páginas: " + numeroDePaginas + ", Local: " + localizacao + String.format(" (%.1f%% lido)", getProgressoPercentual());
    }
}
