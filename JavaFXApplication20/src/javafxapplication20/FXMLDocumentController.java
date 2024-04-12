/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication20;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Faltas;

/**
 *
 * @author kakas
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Spinner<Integer> spnFaltas;
    @FXML
    private TextField txtCodDiciplina;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Button btnApagar;
    @FXML
    private Button btnInserir;
    @FXML
    private TableView<Faltas> tblFaltas;
    @FXML
    private TableColumn<Faltas, Integer> colMatricula;
    @FXML
    private TableColumn<Faltas, String> colDiciplina;
    @FXML
    private TableColumn<Faltas, Integer> colFaltas;
    ObservableList<Faltas> obsFaltas = FXCollections.observableArrayList();
    @FXML
    private Button btnAlterar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valor = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0, 1);
        spnFaltas.setValueFactory(valor);
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        colDiciplina.setCellValueFactory(new PropertyValueFactory<>("codDisciplina"));
        colFaltas.setCellValueFactory(new PropertyValueFactory<>("faltas"));
        tblFaltas.setItems(obsFaltas);
        Faltas f = new Faltas(8784, "cfi0258", 5);
        obsFaltas.add(f);
        tblFaltas.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selecionarAluno(newValue));

    }

    @FXML
    private void btnApagarClick(ActionEvent event) {
        Faltas f = tblFaltas.getSelectionModel().getSelectedItem();
        if (f != null) {
            obsFaltas.remove(f);
        }

    }

    @FXML
    private void btnInserirClick(ActionEvent event) {
        Integer matricula = Integer.valueOf(txtMatricula.getText());
        String codDisciplina = txtCodDiciplina.getText();
        Integer faltas = spnFaltas.getValue();
        Faltas f = new Faltas(matricula, codDisciplina, faltas);
        obsFaltas.add(f);

    }

    public void selecionarAluno(Faltas f) {
        if (f != null) {
            txtCodDiciplina.setText(f.getCodDisciplina());
            txtMatricula.setText(String.valueOf(f.getMatricula()));
            spnFaltas.getValueFactory().setValue(f.getFaltas());
        }
    }

    @FXML
    private void btnAlterarClick(ActionEvent event) {
        Faltas f = tblFaltas.getSelectionModel().getSelectedItem();
        if (f != null) {
            Integer newMatricula = Integer.valueOf(txtMatricula.getText());
            String newCodDiciplina = txtCodDiciplina.getText();
            Integer newfaltas = spnFaltas.getValueFactory().getValue();
            System.out.println(newMatricula + "\n" + newCodDiciplina + "\n" + newfaltas);
            f.setCodDisciplina(newCodDiciplina);
            f.setFaltas(newfaltas);
            f.setMatricula(newMatricula);
            tblFaltas.refresh();

        }

    }
    private void limpar(){
        txtCodDiciplina.setText("");
        txtMatricula.setText("");
        spnFaltas.getValueFactory().setValue(0);
    }
    }

