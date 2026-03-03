<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.Button?>
<?import javafx.scene.image.Image?>
<?import javafx.scene.image.ImageView?>
<?import javafx.scene.layout.AnchorPane?>

<AnchorPane id="AnchorPane" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/23.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="controller.TelaInicialProjetoBibliotecaController">
   <children>
      <AnchorPane layoutY="-2.0" prefHeight="434.0" prefWidth="164.0" style="-fx-background-color: blue;">
         <children>
            <Button fx:id="BotaoLivros" layoutX="29.0" layoutY="71.0" mnemonicParsing="false" onAction="#OnActionBotaoLivros" prefHeight="26.0" prefWidth="82.0" text="Livros" />
         </children>
      </AnchorPane>
      <ImageView fitHeight="434.0" fitWidth="434.0" layoutX="166.0" layoutY="-2.0" pickOnBounds="true" preserveRatio="true">
         <image>
            <Image url="@../icons/telaPrincipal.png" />
         </image>
      </ImageView>
   </children>
</AnchorPane>
