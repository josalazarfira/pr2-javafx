package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ReporteController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ReportesViewController {

    ReporteController reporteController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bt3;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn4;

    @FXML
    private TextArea txt1;

    @FXML
    private TextArea txt2;

    @FXML
    private TextField txtRango;

    @FXML
    void onObtenerObjetos(ActionEvent event) {

        if(!txtRango.getText().isEmpty()){
            String reporteObjetos = reporteController.obtenerObjetosPrestados(txtRango.getText());
            txt1.setText(reporteObjetos);
        }
    }

    @FXML
    void initialize() {
        reporteController = new ReporteController();
    }
}
