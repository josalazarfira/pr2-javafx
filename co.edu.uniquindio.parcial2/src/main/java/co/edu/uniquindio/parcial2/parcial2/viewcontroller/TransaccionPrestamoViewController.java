package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.TransaccionPrestamoController;
import co.edu.uniquindio.parcial2.parcial2.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransaccionPrestamoViewController {

    TransaccionPrestamoController transaccionPrestamoController;

    ObservableList<PrestamoDto> listaPrestamos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<PrestamoDto> tablePrestamos;

    @FXML
    private URL location;

    @FXML
    private TableColumn<PrestamoDto, String> tcCliente;

    @FXML
    private TableColumn<PrestamoDto, String> tcClienteCedula;

    @FXML
    private TableColumn<PrestamoDto, String> tcCodigoObjeto;

    @FXML
    private TableColumn<PrestamoDto, String> tcEmpleado;

    @FXML
    private TableColumn<PrestamoDto, String> tcEmpleadoCedula;

    @FXML
    private TableColumn<PrestamoDto, String> tcFechaEntrega;

    @FXML
    private TableColumn<PrestamoDto, String> tcFechaPrestamo;

    @FXML
    private TableColumn<PrestamoDto, String> tcNombreObjeto;

    @FXML
    private TableColumn<PrestamoDto, String> tcNumeroPrestamo;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextField txtClienteCedula;

    @FXML
    private TextField txtCodigoObjeto;

    @FXML
    private TextField txtEmpleado;

    @FXML
    private TextField txtEmpleadoCedula;

    @FXML
    private TextField txtFechaEntrega;

    @FXML
    private TextField txtFechaPrestamo;

    @FXML
    private TextField txtNombreObjeto;

    @FXML
    private TextField txtNumPrestamo;

    @FXML
    private Button btnAgregar;

    @FXML
    void actionAgregar(ActionEvent event) {
        agregarPrestamo();

    }

    @FXML
    void initialize() {
        transaccionPrestamoController = new TransaccionPrestamoController();
        initView();

    }


    private void agregarPrestamo() {


        //1-Crear un Dto con los campos de texto
        PrestamoDto prestamoDto = buildPrestamoDto();

        //2. mando a crear el prestamo
        transaccionPrestamoController.crearPrestamo(prestamoDto);


    }


    private PrestamoDto buildPrestamoDto() {
        return new PrestamoDto(
               txtNumPrestamo.getText(),
               txtFechaPrestamo.getText(),
                txtFechaEntrega.getText(),
                txtCliente.getText(),
                txtClienteCedula.getText(),
                txtEmpleado.getText(),
                txtEmpleadoCedula.getText(),
                txtNombreObjeto.getText(),
                txtCodigoObjeto.getText()
        );
    }


    private void initView() {
        initDataBinding();
        obtenerPrestamos();
        tablePrestamos.getItems().clear();
        tablePrestamos.setItems(listaPrestamos);

    }

    private void initDataBinding() {
        tcNumeroPrestamo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().numeroPrestamo()));
        tcFechaPrestamo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaPrestamo()));
        tcFechaEntrega.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaEntrega()));
        tcCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreCliente()));
        tcClienteCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaCliente()));
        tcEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreEmpleado()));
        tcEmpleadoCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedulaEmpleado()));
        tcNombreObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreObjeto()));
        tcCodigoObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigoObjeto()));
        //        tcEmpleadoCedula.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().salario())));
    }

    private void obtenerPrestamos() {
        listaPrestamos.addAll(transaccionPrestamoController.obtenerPrestamos());
    }

}
