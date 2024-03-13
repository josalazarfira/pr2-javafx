package co.edu.uniquindio.cliente.clienteapp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.cliente.clienteapp.factory.ModelFactory;
import co.edu.uniquindio.cliente.clienteapp.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ClienteController {

    ModelFactory modelFactory;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCelular;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefonoFijo;

    @FXML
    private TextArea txtResultado;

    @FXML
    private Button btnMayorEdad;

    @FXML
    private Button btnObtenerPorCiudad;

    @FXML
    private TextArea txtResultadoOperacciones;

    @FXML
    private TextField txtCiudadParametro;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onObtenerPorCiudad(ActionEvent event) {
        obtenerPorCiudad();
    }

    private void obtenerPorCiudad() {
        if(!txtCiudadParametro.getText().isEmpty()){
            String resultado = modelFactory.obtenerClientesPorCiudad(txtCiudadParametro.getText());
            txtResultadoOperacciones.setText(resultado);
        }else{
            txtResultadoOperacciones.setText("El campo esta vacio, es requerido....");
        }
    }

    @FXML
    void initialize() {
        modelFactory = ModelFactory.getInstancia();
    }

    private void agregarCliente() {
//        Cliente cliente = new Cliente();
//        cliente.setNombre(txtNombre.getText());
//        cliente.setApellido(txtApellido.getText());
//        cliente.setCedula(txtCedula.getText());
//        cliente.setEdad(Integer.parseInt(txtEdad.getText()));
//        cliente.setTelefonoFijo(txtTelefonoFijo.getText());
//        cliente.setTelefonoCelular(txtCelular.getText());
//        txtResultado.setText(cliente.toString());


        // 1. validar los campos que esten completos
        // de acuerdo al tipo de usuario

        //2. crear el cliente
//        boolean creado = modelFactory.crearCliente(txtNombre.getText(),);

        //3. emitir un mensaje de acuerdo al estado

    }



}

