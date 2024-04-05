/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package cfi028_provab_8784;

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
import model.Ingresso;

/**
 *
 * @author kakas
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
    private ListView<Ingresso> lstVendas;
    @FXML
    private TextField txtIdade;
    @FXML
    private CheckBox chkPipoca;
    @FXML
    private CheckBox chkRefri;
    @FXML
    private CheckBox chkSuco;
    @FXML
    private CheckBox chkChocolate;
    @FXML
    private RadioButton rbComum;
    @FXML
    private ToggleGroup tgCadeiras;
    @FXML
    private RadioButton rbEspecial;
    @FXML
    private RadioButton rbLuxo;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnTotal;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblCadeira;
    
    ObservableList <Ingresso> obsIngresso = FXCollections.observableArrayList();
    
    double[] precoIngresso = {50.0,25.0,0.0};


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializarComponentes();
    }    
    
    public void inicializarComponentes(){
    lstVendas.setItems(obsIngresso);
    cbTipos.getItems().addAll("Inteira","Meia","Cortesia");
    rbComum.selectedProperty().setValue(Boolean.TRUE);
    cbTipos.getSelectionModel().selectFirst();
    txtNome.requestFocus();
        
    }

    public void alerta (String mensagem){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
    
    public void limpar(){
        txtNome.clear();
        txtIdade.clear();
        chkChocolate.selectedProperty().setValue(Boolean.FALSE);
        chkPipoca.selectedProperty().setValue(Boolean.FALSE);
        chkRefri.selectedProperty().setValue(Boolean.FALSE);
        chkSuco.selectedProperty().setValue(Boolean.FALSE);
        rbComum.selectedProperty().setValue(Boolean.TRUE);
        rbEspecial.selectedProperty().setValue(Boolean.FALSE);
        rbLuxo.selectedProperty().setValue(Boolean.FALSE);
        cbTipos.setValue("Inteira");
        txtNome.requestFocus();
          
    }
    
    @FXML
    private void btnFecharClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnCadastrarClick(ActionEvent event) {
        if(!cbTipos.getSelectionModel().isEmpty()){
            int posicao = cbTipos.getSelectionModel().getSelectedIndex();
            double preco = precoIngresso[posicao];
            RadioButton rbCadeiras = (RadioButton) tgCadeiras.getSelectedToggle();
            String ingresso="";
            String cadeira;
            String nome = txtNome.getText();
            int idade = Integer.parseInt(txtIdade.getText());
            if(nome.isEmpty()){
                alerta("Verifique o nome digitado");
                txtNome.requestFocus();
            }else{
                ingresso = ingresso + cbTipos.getValue() + ",";
              
               if(chkChocolate.isSelected()){
                   ingresso = ingresso + "Chocolate e Doces, ";
                   preco+= 15.0;
               }
               if(chkPipoca.isSelected()){
                   ingresso = ingresso + "Pipoca, ";
                   preco+= 32.0;
               }
               if(chkRefri.isSelected()){
                   ingresso = ingresso + "Refri, ";
                   preco+= 20.0;
               }
               if(chkSuco.isSelected()){
                   ingresso = ingresso+ "Suco, ";
                   preco+= 25.0;
               }
               
               cadeira = rbCadeiras.getText();
               ingresso = ingresso + cadeira + ".";
               
               Ingresso i = new Ingresso(nome, idade, ingresso, preco);
               obsIngresso.add(i);
                System.out.println("aqui");
               lblCadeira.setText("Cadeira: "+ cbTipos.getValue());
               
                
            }
        }
    }

    @FXML
    private void btnApagarClick(ActionEvent event) {
        limpar();
        int posicao = lstVendas.getSelectionModel().getSelectedIndex();
        if(posicao >=0){
            obsIngresso.remove(posicao);
        }

    }

    @FXML
    private void btnTotalClick(ActionEvent event) {
        double total=0.0;
        for(Ingresso i:obsIngresso){
            total= total+ i.getPreco();
        }
        lblValor.setText(" "+total);
    }
    
}
