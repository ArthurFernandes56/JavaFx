/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package cfi028_provab_8784;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
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
import javafx.scene.control.TextFormatter;
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
    
    Double[] precoIngresso = {50.0,25.0,0.0};
    Double[] precoCadeira = {0.0,10.0,25.0};
    @FXML
    private Label lblTotal;


    
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
    UnaryOperator<TextFormatter.Change> filtro = change -> {
    String newText = change.getControlNewText();
    if (newText.isEmpty() || newText.matches("-?[0-9]+")) {  
    return change;
   }
    return null;
   };
  TextFormatter<String> textoFormatado = new TextFormatter<>(filtro); //perguntar ao toninho se é Tipo string por que o txt retorna o valor string.
  txtIdade.setTextFormatter(textoFormatado);
 
    
        
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
        cbTipos.getSelectionModel().selectFirst();
          
    }
    
    @FXML
    private void btnFecharClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnCadastrarClick(ActionEvent event) {
        
            int posicaoTipo = cbTipos.getSelectionModel().getSelectedIndex();
            double preco = precoIngresso[posicaoTipo];
            RadioButton rbCadeiras = (RadioButton) tgCadeiras.getSelectedToggle();
            int posicaoCadeira = (int) tgCadeiras.getToggles().indexOf(rbCadeiras);
            preco+= precoCadeira[posicaoCadeira];
            String texto="";
            String cadeira;
            String nome = txtNome.getText();
            Integer idade = Integer.valueOf(txtIdade.getText());

            if(txtNome.getText().isEmpty()){
                alerta("Verifique o nome digitado!");
                txtNome.requestFocus();
            }else if(txtIdade.getText().isEmpty()||(idade<=0)){
                alerta("Verifique a idade digitada!");
                txtIdade.clear();
            }else{
               
                texto = texto + cbTipos.getValue() + ",";
              
               if(chkChocolate.isSelected()){
                   texto = texto + "Chocolate e Doces, ";
                   preco+= 15.0;
               }
               if(chkPipoca.isSelected()){
                   texto = texto + "Pipoca, ";
                   preco+= 32.0;
               }
               if(chkRefri.isSelected()){
                   texto = texto + "Refri, ";
                   preco+= 20.0;
               }
               if(chkSuco.isSelected()){
                   texto = texto+ "Suco, ";
                   preco+= 25.0;
               }
               
               cadeira = rbCadeiras.getText();
               texto = texto + cadeira + ".";
                
               Ingresso i = new Ingresso(nome, texto, idade, preco);
               obsIngresso.add(i);
                System.out.println("aqui");
               lblCadeira.setText("Selecionado: "+ rbCadeiras.getText());
               lblValor.setText("Valor: "+preco);
               
                
            }
        
    }

    @FXML
    private void btnApagarClick(ActionEvent event) {        //Perguntar ao toninho como reativar o buton 
        limpar();
        int posicao = lstVendas.getSelectionModel().getSelectedIndex();
        if(posicao >=0){
            obsIngresso.remove(posicao);
        } else if(obsIngresso.isEmpty()){
            btnApagar.setDisable(false);      
        } else{
            btnApagar.setDisable(true);
        }

    }

    @FXML
    private void btnTotalClick(ActionEvent event) {
        Double total=0.0;
        for(Ingresso i:obsIngresso){
        total+=Double.valueOf(i.getPreco());
        }
        lblTotal.setText("Fechamento do dia: "+total);
    }
    
}
