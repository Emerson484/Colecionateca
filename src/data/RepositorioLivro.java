
package data;
// RepositorioLivro.java - Implementa ILivro e salva dados em arquivo
// Repositório que armazena livros e eBooks usando serialização em arquivo

import java.io.*;
import java.util.*;
import model.ILivro;
import model.Livro;

public class RepositorioLivro implements ILivro {
    private List<Livro> livros;//A lista que armazena os objetos Livro (e suas subclasses Ebook e LivroFisico).
    private final String arquivo = "livros.dat"; //O nome do arquivo onde a lista de livros será armazenada

    //Ao ser instanciado, ele inicializa a lista de livros e imediatamente chama o método lerArquivo()
    // para carregar quaisquer dados que possam ter sido salvos em uma execução anterior do programa.
    public RepositorioLivro() {
        livros = new ArrayList<>();
        lerArquivo();
    }

    // Adiciona um livro à coleção em memória e persiste a lista atualizada no arquivo
    public void adicionar(Livro livro) {
        livros.add(livro);
        salvarArquivo();
    }

    //Retorna uma cópia da lista de todos os livros cadastrados
    public List<Livro> listar() {
        return new ArrayList<>(livros);
    }

    //Busca um livro na coleção pelo seu ISBN(código)
    public Livro buscar(String isbn) {
        for (Livro l : livros) {
            if (l.getIsbn().equals(isbn)) return l;
        }
        return null;
    }

    //Atualiza um livro existente na coleção
    public void atualizar(Livro livro) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIsbn().equals(livro.getIsbn())) {
                livros.set(i, livro);
                salvarArquivo();
                return;
            }
        }
    }

    //Remover o elemento da lista caso o isbn desejado esteja na lista
    public void remover(String isbn) {
        Iterator<Livro> iterador = livros.iterator();
        while (iterador.hasNext()) {
            Livro livro = iterador.next();
            if (livro.getIsbn().equals(isbn)) {
                iterador.remove();
                break;
            }
        }
        salvarArquivo(); //atualiza o arquivo com a remoção efetuada
    }

    //Método auxiliar para a lista 'livros' no arquivo 'livros.dat'
    //Utiliza a serialização de objetos Java para escrever a lista inteira de uma vez.
    private void salvarArquivo() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(livros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Já esse desserializa o objeto do arquivo e o carrega na lista 'livros'
    private void lerArquivo() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            livros = (List<Livro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Se o arquivo não existe ou está vazio, inicializa uma nova lista
            livros = new ArrayList<>();
        }
    }
}
