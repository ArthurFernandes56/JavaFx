/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package imc1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kakas
 */
public class Tela1Controller implements Initializable {
    
    @FXML
    private TextField lblPeso;
    @FXML
    private TextField lblAltura;
    @FXML
    private Label lblResultado;
    @FXML
    private Button btnCalcular;
    @FXML
    private Button btnLimpar;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickCalcular(ActionEvent event) {
        double peso, altura,imc;
        peso= Double.parseDouble(lblPeso.getText());
        altura= Double.parseDouble(lblAltura.getText());
        imc=peso/altura; 
        
    }

    @FXML
    private void clickLimpar(ActionEvent event) {
    }
    
}
