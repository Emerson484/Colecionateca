
package model;

// ILivro.java - Interface para operações CRUD de livros
// Interface com operações básicas do repositório de livros

import java.util.List;

public interface ILivro {
    //obriga as classes que implementarem ILivro a implementarem os métodos abaixo:
    void adicionar(Livro livro);
    List<Livro> listar();
    Livro buscar(String isbn);
    void atualizar(Livro livro);
    void remover(String isbn);
}
