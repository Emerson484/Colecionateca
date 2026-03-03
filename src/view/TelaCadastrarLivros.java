<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.ChoiceBox?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.VBox?>

<AnchorPane id="AnchorPane" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/23.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="controller.TelaCadastrarLivrosController">
   <children>
      <ImageView fitHeight="390.0" fitWidth="612.0" layoutX="7.0" layoutY="5.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@../icons/imagemTela.png" />
         </image>
      </ImageView>
      <TextField fx:id="fieldTitulo" layoutX="234.0" layoutY="52.0" prefHeight="26.0" prefWidth="150.0" promptText="titulo" />
      <Label fx:id="labelStatus" alignment="CENTER" layoutX="192.0" layoutY="361.0" prefHeight="34.0" prefWidth="223.0" />
      <TextField fx:id="fieldAutor" layoutX="235.0" layoutY="86.0" prefHeight="26.0" prefWidth="150.0" promptText="autor" />
      <TextField fx:id="fieldIsbn" layoutX="235.0" layoutY="122.0" prefHeight="26.0" prefWidth="150.0" promptText="isbn" />
      <TextField fx:id="fieldAno" layoutX="234.0" layoutY="161.0" prefHeight="26.0" prefWidth="150.0" promptText="ano" />
      <Label alignment="CENTER" layoutX="215.0" layoutY="16.0" prefHeight="26.0" prefWidth="150.0" text="Tela de cadastro" />
      <Label alignment="CENTER" layoutX="44.0" layoutY="85.0" prefHeight="26.0" prefWidth="170.0" text="Digite as informacões do livro" />
      <ChoiceBox fx:id="seletorTipoLivro" layoutX="234.0" layoutY="202.0" prefHeight="26.0" prefWidth="150.0" />
      <VBox fx:id="painelEbook" layoutX="232.0" layoutY="305.0" prefHeight="51.0" prefWidth="158.0">
         <children>
            <TextField fx:id="campoTamanho" prefHeight="26.0" prefWidth="162.0" promptText="tamanho em mb" />
            <TextField fx:id="campoFormato" prefHeight="31.0" prefWidth="158.0" promptText="formato" />
         </children>
      </VBox>
      <VBox fx:id="painelLivroFisico" layoutX="230.0" layoutY="244.0" prefHeight="51.0" prefWidth="158.0">
         <children>
            <TextField fx:id="campoLocalizacao" promptText="localizacao" />
            <TextField fx:id="campoNumeroPaginas" prefHeight="26.0" prefWidth="147.0" promptText="numero de paginas" />
         </children>
      </VBox>
      <Button fx:id="botaoSalvar" layoutX="454.0" layoutY="343.0" mnemonicParsing="false" onAction="#ONActoinSalvar" prefHeight="26.0" prefWidth="94.0" text="salvar" />
      <Button fx:id="botaoSalvar1" layoutX="57.0" layoutY="343.0" mnemonicParsing="false" onAction="#ONActoinVoltar" prefHeight="26.0" prefWidth="94.0" text="voltar" />
   </children>
</AnchorPane>
