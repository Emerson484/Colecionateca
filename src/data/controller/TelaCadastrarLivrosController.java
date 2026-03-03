package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastrarLivrosController implements Initializable {
    private ControleLivro controleLivro = new ControleLivro();
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private TextField fieldTitulo;
    @FXML
    private TextField fieldAutor;
    @FXML
    private TextField fieldIsbn;
    @FXML
    private TextField fieldAno;
    @FXML
    private ChoiceBox<String> seletorTipoLivro;
    @FXML
    private VBox painelEbook;
    @FXML
    private TextField campoTamanho;
    @FXML
    private TextField campoFormato;
    @FXML
    private VBox painelLivroFisico;
    @FXML
    private TextField campoLocalizacao;
    @FXML
    private TextField campoNumeroPaginas;
    @FXML
    private Button botaoSalvar;
    @FXML
    private Button botaoSalvar1;
    @FXML
    private Label labelStatus;
    
    //private AnchorPane labelStatus;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // 1. Adiciona as opções de texto ao ChoiceBox
        seletorTipoLivro.getItems().addAll("Livro Físico", "Ebook");

        // 2. Define um valor padrão para que a tela já comece com uma opção selecionada
        seletorTipoLivro.setValue("Livro Físico");

        // 3. Adiciona um "ouvinte" (listener) que reage a mudanças no ChoiceBox
        seletorTipoLivro.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue == null) return;
                
                // Lógica para mostrar/ocultar os painéis corretos
                boolean isLivroFisico = newValue.equals("Livro Físico");
                
                painelLivroFisico.setVisible(isLivroFisico);
                painelLivroFisico.setManaged(isLivroFisico); // Faz ocupar espaço ou não

                painelEbook.setVisible(!isLivroFisico);
                painelEbook.setManaged(!isLivroFisico); // O inverso da seleção
            }
        );
    }    



@FXML
private void ONActoinSalvar(ActionEvent event) {
    try {
        
        String titulo = fieldTitulo.getText();
        String autor = fieldAutor.getText(); 
        String isbn = fieldIsbn.getText();   
        int ano = Integer.parseInt(fieldAno.getText());

        // Verifica qual tipo de livro está selecionado
        String tipoSelecionado = seletorTipoLivro.getValue();

        if (tipoSelecionado.equals("Livro Físico")) {
            int numeroPaginas = Integer.parseInt(campoNumeroPaginas.getText());
            String localizacao = campoLocalizacao.getText();

            // Chama o método a partir do OBJETO (com "c" minúsculo)
            controleLivro.adicionarLivroFisico(titulo, autor, isbn, ano, numeroPaginas, localizacao);
            System.out.println("Livro Físico salvo com sucesso!");
        
             labelStatus.setText("Livro Físico salvo com sucesso!");

        } else if (tipoSelecionado.equals("Ebook")) {
            double tamanho = Double.parseDouble(campoTamanho.getText());
            String formato = campoFormato.getText();

            // Chama o método a partir do OBJETO 
            controleLivro.adicionarEbook(titulo, autor, isbn, ano, tamanho, formato);
            System.out.println("Ebook salvo com sucesso!");
         
             labelStatus.setText("Ebook salvo com sucesso!");
        }
        limparCampos();

    } catch (NumberFormatException e) {
        System.out.println("Erro: 'Ano', 'Páginas' e 'Tamanho' devem ser números.");
         labelStatus.setText("Erro: 'Ano', 'Páginas' e 'Tamanho' devem ser números.");
    } catch (Exception e) {
        System.out.println("Ocorreu um erro: " + e.getMessage());
         labelStatus.setText("Ocorreu um erro: " + e.getMessage());
    }
}
    private void limparCampos() {
        fieldTitulo.clear();
        fieldAutor.clear();
        fieldIsbn.clear();
        fieldAno.clear();
        campoNumeroPaginas.clear();
        campoLocalizacao.clear();
        campoTamanho.clear();
        campoFormato.clear();
    }


     @FXML
    public void ONActoinVoltar(ActionEvent event) throws IOException,RuntimeException{
        Parent root = FXMLLoader.load (getClass().getResource("/fxml/TelaLivros.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
