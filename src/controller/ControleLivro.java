package controller;

import data.RepositorioLivro;
import java.util.*;
import model.Ebook;
import model.ILivro;
import model.Livro;
import model.LivroFisico;

public class ControleLivro {
    private ILivro repositorio;

    public ControleLivro() {
        repositorio = new RepositorioLivro();
    }

    //método para adicionar livro físico na lista repositorio
    public void adicionarLivroFisico(String titulo, String autor, String isbn, int ano, int numeroDePaginas, String localizacao) {
        LivroFisico livro = new LivroFisico(titulo, autor, isbn, ano, numeroDePaginas, localizacao);
        repositorio.adicionar(livro);
    }

    //método para adicionar ebook da classe Livro na lista repositorio
    public void adicionarEbook(String titulo, String autor, String isbn, int ano, double tamanhoMB, String formato) {
        Ebook ebook = new Ebook(titulo, autor, isbn, ano, tamanhoMB, formato);
        repositorio.adicionar(ebook);
    }

    //método de busca pelo código(ibsn)
    public Livro buscarLivro(String isbn) {
        return repositorio.buscar(isbn);
    }

    //método para remover livro da lista pelo código(isbn)
    public void removerLivro(String isbn) {
        repositorio.remover(isbn);
    }

    //método de atualização do progresso
    public void atualizarProgresso(String isbn, int novoProgresso) {
        Livro livro = repositorio.buscar(isbn);
        if (livro != null) {
            livro.setProgresso(novoProgresso);
            repositorio.atualizar(livro);
        }
    }

    //método para listar todos os livros
    public List<Livro> listarTodosOsLivros() {
        return repositorio.listar();
    }

    // Método de listagem apenas dos livros físicos
    public List<LivroFisico> listarLivrosFisicos() {
        List<LivroFisico> fisicos = new ArrayList<>();
        for (Livro l : repositorio.listar()) {
            if (l instanceof LivroFisico) {
                fisicos.add((LivroFisico) l);
            }
        }
        return fisicos;
    }

    // Método de listagem apenas dos ebooks
    public List<Ebook> listarEbooks() {
        List<Ebook> ebooks = new ArrayList<>();
        for (Livro l : repositorio.listar()) {
            if (l instanceof Ebook) {
                ebooks.add((Ebook) l);
            }
        }
        return ebooks;
    }
}
