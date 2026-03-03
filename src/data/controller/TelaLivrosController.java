package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Livro;

public class TelaLivrosController implements Initializable {
    private ControleLivro controleLivro = new ControleLivro();
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button remover;
    @FXML
    private Button atualizar;
    @FXML
    private Button criar;
    @FXML
    private Button pesquisar;
    
    @FXML
    private TableColumn<Livro,String> tituloId;
    @FXML
    private TableColumn<Livro,String> autorId;
    @FXML
    private TableColumn<Livro,String> isbnId;
    @FXML
    private TableColumn<Livro,String> anoId;
    @FXML
    private TableColumn<Livro,String> progressoId;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableView<Livro> tabelaLivros;
    @FXML
    private Button voltar;
    @FXML
    private Button detalhes;
    @FXML
    private Button atualizarProgresso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tituloId.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        autorId.setCellValueFactory(new PropertyValueFactory<>("autor"));
        isbnId.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        anoId.setCellValueFactory(new PropertyValueFactory<>("ano"));
        progressoId.setCellValueFactory(new PropertyValueFactory<>("progresso"));
        
        carregarTabelaLivros();
    }    

    @FXML
    private void OnActionRemover(ActionEvent event) {
        Livro livroSelecionado = tabelaLivros.getSelectionModel().getSelectedItem();
        
        //Verifica se o usuário realmente selecionou um livro
        if(livroSelecionado!=null){
            Alert alerta=new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("confirmar remocao");
            alerta.setHeaderText(null);
            alerta.setContentText("deseja realmente remover o livro"+livroSelecionado.getTitulo());
            
           // Mostra o alerta e espera pela resposta do usuário          
           Optional<ButtonType> result=alerta.showAndWait();
           
           //Se o usuário clicou no botão "OK"
           if(result.isPresent() && result.get()==ButtonType.OK){
               //// Chama o método ControleLivro para remover o livro pelo titulo
               controleLivro.removerLivro(livroSelecionado.getIsbn()); //obs o metodo de remocao de controleLivro remove 
               //por meio do isbn
               //// Atualiza a tabela depois de remover
               carregarTabelaLivros();
            
           }else{
               Alert NovoAlerta=new Alert(Alert.AlertType.WARNING);
            NovoAlerta.setTitle("nenhum livro selecionado!");
            NovoAlerta.setHeaderText(null);
            NovoAlerta.setContentText("selecione um livro na tabela antes de remover!");
               
           }        
            
        }
    }

    @FXML
    private void OnActionaAualizar() {
        System.out.println("atualizando");
        carregarTabelaLivros();
        
    }
    public void carregarTabelaLivros(){
        tabelaLivros.getItems().clear();
        List<Livro>listaDeLivros= controleLivro.listarTodosOsLivros();
        tabelaLivros.getItems().addAll(listaDeLivros);
        
    }
   
    @FXML
    public void OnActionaCriar(ActionEvent event) throws IOException,RuntimeException{
        Parent root = FXMLLoader.load (getClass().getResource("/fxml/TelaCadastrarLivros.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void ONActionPesquisar() {
       // O .trim() remove espaços em branco no início e no fim.
        
       String digitado =campoPesquisa.getText().toLowerCase().trim();
       // Se o campo de pesquisa estiver vazio, simplesmente recarregamos a tabela com todos os livros.
       if(digitado.isEmpty()){
           carregarTabelaLivros();
           return;// Encerra a execução do método aqui.       
       }
       
       List<Livro> todosOsLivros= controleLivro.listarTodosOsLivros();
       
       List<Livro> livrosFiltrados= new ArrayList<>();
       
      // Percorre a lista de todos os livros, um por um.
      for(Livro l :todosOsLivros)  {
          if(l.getAutor().toLowerCase().contains(digitado)|| //usei o contains em vez de equals pra nao precisar digitar 
             l.getTitulo().toLowerCase().contains(digitado)){ //exatamente correto pra peesquisar
              
              // Se a condição for verdadeira, adiciona o livro na lista de resultados.
              livrosFiltrados.add(l);
          }
          
      }
      //limpar tabela
          tabelaLivros.getItems().clear();
          //exibe  os livros que foram encontrados na busca
          tabelaLivros.getItems().addAll(livrosFiltrados);
       
       
       
    }

     @FXML
    public void voltarTelaInicial(ActionEvent event) throws IOException,RuntimeException{
        Parent root = FXMLLoader.load (getClass().getResource("/fxml/TelaInicialProjetoBiblioteca.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


@FXML
private void onActionDetalhes(ActionEvent event) {
    //  Pega o livro selecionado 
    Livro livroSelecionado = tabelaLivros.getSelectionModel().getSelectedItem();

    //  Verifica se um livro foi selecionado 
    if (livroSelecionado == null) {
        Alert aviso = new Alert(AlertType.WARNING);
        aviso.setTitle("Nenhum Livro Selecionado");
        aviso.setHeaderText(null);
        aviso.setContentText("Por favor, selecione um livro na tabela para ver os detalhes.");
        aviso.showAndWait();
        return;
    }

    
    //  chamamos o método toString() do objeto selecionado.
    // por polimorfismo ele sabe qual toString usar (de LivroFisico ou Ebook).
    String detalhesCompletos = livroSelecionado.toString();

    //  Cria e exibe uma mensagem
    Alert infoPopup = new Alert(AlertType.INFORMATION);
    infoPopup.setTitle("Detalhes do Livro");
    infoPopup.setHeaderText("Detalhes para: " + livroSelecionado.getTitulo());
    infoPopup.setContentText(detalhesCompletos);
    infoPopup.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

    infoPopup.showAndWait();
}

    @FXML
    private void OnActionaAualizarProgresso(ActionEvent event) {
        //Pega o livro selecionado na tabela
        Livro livroSelecionado=tabelaLivros.getSelectionModel().getSelectedItem();
        
        if(livroSelecionado==null){
            Alert alerta = new Alert(Alert.AlertType.WARNING); //criar alerta de aviso
            alerta.setTitle("nenhum livro selecionado ");
            alerta.setHeaderText(null);
            alerta.setContentText("selecione um livro pra atualizar progresso");
            alerta.showAndWait(); //esperar resposta
            return; // encerra o metodo
            
        }
        //Mostra o pop-up e espera o usuário digitar e clicar "OK" ou "Cancelar"
        TextInputDialog dialog = new TextInputDialog(String.valueOf(livroSelecionado.getProgresso()));
        dialog.setTitle("livro"+livroSelecionado.getTitulo());
        dialog.setHeaderText(null);
        dialog.setContentText("atualizar progresso do livro,digite a porcentagem!");
        
        //Mostra balaozinho e espera o usuário digitar e clicar "OK" ou "Cancelar"
        Optional<String> resultado=dialog.showAndWait();
        
        //'resultado.isPresent()' será verdadeiro se o usuário clicou em "OK".
        if(resultado.isPresent()){
            try{
            int novoProgresso=Integer.parseInt(resultado.get()); //cria uma variavel pra armazenar o novo progresso
            controleLivro.atualizarProgresso(livroSelecionado.getIsbn(), novoProgresso);//usa o metodo de controlLivro
            carregarTabelaLivros();
            //// pra atualizar progresso
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        } 
        
    }
}
