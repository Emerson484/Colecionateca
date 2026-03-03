<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TableColumn?>
<?import javafx.scene.control.TableView?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.layout.HBox?>
<?import javafx.scene.layout.VBox?>
<?import javafx.scene.text.Font?>

<AnchorPane id="AnchorPane" prefHeight="386.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/23.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="controller.TelaLivrosController">
   <children>
      <VBox alignment="TOP_CENTER" prefHeight="400.0" prefWidth="600.0">
         <children>
            <Label alignment="CENTER" contentDisplay="CENTER" prefHeight="37.0" prefWidth="107.0" text="livros">
               <font>
                  <Font size="20.0" />
               </font>
            </Label>
            <HBox prefHeight="22.0" prefWidth="107.0" />
            <HBox prefHeight="62.0" prefWidth="600.0">
               <children>
                  <Button fx:id="remover" mnemonicParsing="false" onAction="#OnActionRemover" prefHeight="34.0" prefWidth="27.0" text="Button" textFill="TRANSPARENT">
                     <graphic>
                        <ImageView fitHeight="25.0" fitWidth="70.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../icons/excluir.jpeg" />
                           </image>
                        </ImageView>
                     </graphic></Button>
                  <Button fx:id="atualizar" layoutX="10.0" layoutY="10.0" mnemonicParsing="false" onAction="#OnActionaAualizar" prefHeight="26.0" prefWidth="43.0">
                     <graphic>
                        <ImageView fitHeight="27.0" fitWidth="25.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../icons/atualizar.jpeg" />
                           </image>
                        </ImageView>
                     </graphic></Button>
                  <Button fx:id="criar" layoutX="53.0" layoutY="10.0" mnemonicParsing="false" onAction="#OnActionaCriar" prefHeight="26.0" prefWidth="43.0">
                     <graphic>
                        <ImageView fitHeight="26.0" fitWidth="44.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../icons/criar.jpeg" />
                           </image>
                        </ImageView>
                     </graphic></Button>
                  <Button fx:id="detalhes" mnemonicParsing="false" onAction="#onActionDetalhes" prefHeight="34.0" prefWidth="26.0">
                     <graphic>
                        <ImageView fitHeight="23.0" fitWidth="31.0" pickOnBounds="true" preserveRatio="true">
                           <image>
                              <Image url="@../icons/detalhes.jpg" />
                           </image>
                        </ImageView>
                     </graphic></Button>
                  <TextField fx:id="campoPesquisa" prefHeight="34.0" prefWidth="225.0" />
                  <Button fx:id="pesquisar" mnemonicParsing="false" onAction="#ONActionPesquisar" prefHeight="34.0" prefWidth="68.0" text="pesquisar" />
                  <Button fx:id="voltar" mnemonicParsing="false" onAction="#voltarTelaInicial" prefHeight="34.0" prefWidth="51.0" text="Voltar" />
                  <Button fx:id="atualizarProgresso" mnemonicParsing="false" onAction="#OnActionaAualizarProgresso" prefHeight="34.0" prefWidth="72.0" text="progresso" />
               </children>
            </HBox>
            <TableView fx:id="tabelaLivros" prefHeight="298.0" prefWidth="600.0">
              <columns>
                <TableColumn fx:id="tituloId" prefWidth="75.0" text="titulo" />
                <TableColumn fx:id="autorId" prefWidth="75.0" text="autor" />
                  <TableColumn fx:id="isbnId" prefWidth="75.0" text="isbn" />
                  <TableColumn fx:id="anoId" prefWidth="75.0" text="ano" />
                  <TableColumn fx:id="progressoId" prefWidth="75.0" text="progresso" />
              </columns>
            </TableView>
         </children>
      </VBox>
   </children>
</AnchorPane>
