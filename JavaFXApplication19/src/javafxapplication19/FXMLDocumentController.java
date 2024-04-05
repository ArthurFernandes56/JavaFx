/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication19;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import jdk.nashorn.internal.runtime.Property;
import model.Funcionarios;

/**
 *
 * @author kakas
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button button;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtNumD;
    @FXML
    private TextField txtSalario;
    @FXML
    private TableView<Funcionarios> tblFuncionarios;
    @FXML
    private TableColumn<Funcionarios, String> colNome;
    @FXML
    private TableColumn<Funcionarios, Integer> colNumD;
    @FXML
    private TableColumn<Funcionarios, Double> colSalarios;
    ObservableList<Funcionarios> obsFuncionarios = FXCollections.observableArrayList();

    @FXML
    private void handleButtonAction(ActionEvent event) {

        //Funcionarios f = new Funcionarios("Arthur", 2, 3300.0);
        String nome = txtNome.getText();
        Integer numDependentes = Integer.parseInt(txtNumD.getText());
        Double salario = Double.parseDouble(txtSalario.getText());
        Funcionarios f = new Funcionarios(nome, numDependentes, salario);
        obsFuncionarios.add(f);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblFuncionarios.setItems(obsFuncionarios);
        colNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colNumD.setCellValueFactory(new PropertyValueFactory("numDependentes"));
        colSalarios.setCellValueFactory(new PropertyValueFactory("salario"));
    }

}
