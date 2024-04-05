/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package prova1turma1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Clientes;

/**
 *
 * @author kakas
 */
public class telaProva1Controller implements Initializable {
    
    @FXML
    private ComboBox<Clientes> cbUnidades;
    @FXML
    private CheckBox cbCrossfit;
    @FXML
    private CheckBox cbCardio;
    @FXML
    private CheckBox cbDance;
    @FXML
    private CheckBox cbZumba;
    @FXML
    private RadioButton rdTarde;
    @FXML
    private ToggleGroup tgTurno;
    @FXML
    private RadioButton rdManha;
    @FXML
    private RadioButton rdNoite;
    @FXML
    private Label lblResultado;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIdade;
    @FXML
    private ListView<Clientes> lstClientes;
    
    ObservableList<Clientes> obsClientes = FXCollections.observableArrayList();
    @FXML
    private Button btnAlterar;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnInserir;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickBtnAlterar(ActionEvent event) {
    }

    @FXML
    private void clickBtnApagar(ActionEvent event) {
    }

    @FXML
    private void clickBtnInserir(ActionEvent event) {
    }
    
}
