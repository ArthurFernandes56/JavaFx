/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package cfi028_provab_8813;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Aluno
 */
public class telaController implements Initializable {
    
    private Label label;
    @FXML
    private Button btnFechar;
    @FXML
    private TextField txtNome;
    @FXML
    private ComboBox<String> cbTipos;
    @FXML
    private Button btnCadastrar;
    @FXML
    private ListView<compras> lstVendas;
    @FXML
    private ToggleGroup tgCad;
    @FXML
    private RadioButton rbcomum;
    @FXML
    private RadioButton rbespecial;
    @FXML
    private RadioButton rbluxo;
    
    ObservableList<compras> obsCompras = FXCollections.observableArrayList();
    
    Double preco = 0.0;
    Double[] precoIngresso = {25.0, 50.0, 0.0}; 
    @FXML
    private CheckBox chkPipoca;
    @FXML
    private CheckBox chkRefrigerante;
    @FXML
    private CheckBox chkSuco;
    @FXML
    private CheckBox chkChocolates;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnTotal;
    @FXML
    private Label lblTotal;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       cbTipos.getItems().addAll("Meia", "Inteira", "Cortesia"); 
    }    

    @FXML
    private void btnFecharClick(ActionEvent event) {
    }

    @FXML
    private void btnCadastrarClick(ActionEvent event) {
        if (!cbTipos.getSelectionModel().isEmpty()) {
            int posicao = cbTipos.getSelectionModel().getSelectedIndex();
            preco = precoIngresso[posicao];
            RadioButton rbTipos = (RadioButton) tgCad.getSelectedToggle(); 
          String texto = " ";
          String tipos;
          String nome = txtNome.getText();
          int idade = 0;
          if(nome.isEmpty()){
              alerta("Insria um nome para prosseguir.");
           txtNome.requestFocus();
          } else {
              texto = texto + cbTipos.getValue().toUpperCase() + ", ";
               if (rbcomum.isSelected()) {
              preco = preco + 0.0;
              texto = texto + "Cadeira comum, ";}
               if (rbespecial.isSelected()) {
              preco = preco + 10.0;
              texto = texto + "Cadeira especial, ";}
                if (rbluxo.isSelected()) {
              preco = preco + 25.0;
              texto = texto + "Cadeira luxo, ";}
                 if (chkChocolates.isSelected()) {
              preco = preco + 15.0;
              texto = texto + "chocolate, ";}
              if (chkPipoca.isSelected()) {
              preco = preco + 32.0;
              texto = texto + "pipoca, ";}
              if (chkRefrigerante.isSelected()) {
              preco = preco + 20.0;
              texto = texto + "refrigerante, ";}
              if (chkSuco.isSelected()) {
              preco = preco + 25.0;
              texto = texto + "suco, ";}
              if (chkChocolates.isSelected()) {
              preco = preco + 15.0;
              texto = texto + "chocolate, ";}
              
            lstVendas.setItems(obsCompras);      
              
              
          tipos = cbTipos.getSelectionModel().getSelectedItem();
          texto = texto + tipos + ".";
          
          compras c = new compras(nome, idade, texto, preco);
           obsCompras.add(c);
              System.out.println("Aqui");
          
              
          }
          
                                            
        }else{
            alerta("Escolha um tipo de ingresso.");
        }
    }

    @FXML
    private void btnApagarClick(ActionEvent event) {
    int posicao = lstVendas.getSelectionModel().getSelectedIndex(); 
    if (posicao >=0){
        obsCompras.remove(posicao);
    }
    }
   

    @FXML
    private void btnCalcularTotalClick(ActionEvent event) {
           lblTotal.setText(String.format("%.2f", preco));
    }
   public void inicializaComponentes() {
       lstVendas.setItems(obsCompras);
       cbTipos.getItems().addAll("nao aparecia nada quando eu tentava "
               + "colocar por aqui");
       
    
       cbTipos.getSelectionModel().selectFirst();
       txtNome.requestFocus();
       
    lstVendas.setItems(obsCompras);
                
   }
 
    public void alerta(String message) {
         Alert alerta = new Alert(Alert.AlertType.ERROR);
         alerta.setTitle("ERRO");
         alerta.setContentText(message);
         alerta.showAndWait();
             lstVendas.setItems(obsCompras);
    }
 
}
