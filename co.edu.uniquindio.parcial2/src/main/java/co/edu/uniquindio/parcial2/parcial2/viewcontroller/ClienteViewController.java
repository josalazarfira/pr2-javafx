package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ClienteViewController {

    ClienteController clienteController;

    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    FilteredList<Cliente> filteredData = new FilteredList<>(FXCollections.observableList(listaClientes));

    Cliente clienteSeleccionado;

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
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> tcApellido;

    @FXML
    private TableColumn<Cliente, String> tcCedula;

    @FXML
    private TableColumn<Cliente, String> tcCelular;

    @FXML
    private TableColumn<Cliente, String> tcEdad;

    @FXML
    private TableColumn<Cliente, String> tcFijo;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

    @FXML
    private TextField txtSearch;

    @FXML
    void onAgregarCliente(ActionEvent event) {
        agregarCliente();
    }

    @FXML
    void onObtenerPorCiudad(ActionEvent event) {
        obtenerPorCiudad();
    }

    @FXML
    void initialize() {
        clienteController = new ClienteController();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
        listenerFilter();
    }

    private void listenerFilter() {
        tableCliente.setRowFactory(tableView -> {
            TableRow<Cliente> row = new TableRow<>();
            row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), false);
            row.itemProperty().addListener((obs, oldOrder, newOrder) -> {
                boolean assignClass = filteredData.contains(newOrder) &&
                        (newOrder.getNombre().equals(txtSearch.getText()));

                row.pseudoClassStateChanged(PseudoClass.getPseudoClass("highlighted"), assignClass);
            });
            return row;
        });

        txtSearch.textProperty().addListener((observable, oldValue, newValue) ->
                tableCliente.setItems(filterList(listaClientes, newValue.toLowerCase()))
        );
    }

    private ObservableList<Cliente> filterList(List<Cliente> list, String searchText){
        List<Cliente> filteredList = new ArrayList<>();
        for (Cliente order : list){
            if(searchFindsOrder(order, searchText)){
                filteredList.add(order);
            }
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsOrder(Cliente cliente, String searchText){
        return (cliente.getNombre().toLowerCase().contains(searchText));
    }


    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getEdad())));
        tcFijo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefonoFijo()));
        tcCelular.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefonoCelular()));
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.obtenerClientes());
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtCedula.setText(clienteSeleccionado.getCedula());
            txtEdad.setText(String.valueOf(clienteSeleccionado.getEdad()));
            txtTelefonoFijo.setText(clienteSeleccionado.getTelefonoFijo());
            txtCelular.setText(clienteSeleccionado.getTelefonoCelular());
        }
    }

    private void agregarCliente() {
        if(validarFormulario()){
            Cliente cliente = construirDatosClienest();
            if(clienteController.crearCliente(cliente)){
                listaClientes.add(cliente);
                mostrarMensaje("Notificación cliente", "Cliente creado", "El cliente se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposEmpleado();
            }else{
                mostrarMensaje("Notificación cliente", "Cliente no creado", "El cliente no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación cliente", "Cliente no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCamposEmpleado() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtTelefonoFijo.setText("");
        txtCelular.setText("");
    }

    private boolean validarFormulario() {
        if(txtNombre.getText().isEmpty()){
            return false;
        }

        return true;
    }

    private Cliente construirDatosClienest() {
        return Cliente.builder()
                .nombre(txtNombre.getText())
                .apellido(txtApellido.getText())
                .cedula(txtCedula.getText())
                .edad(Integer.parseInt(txtEdad.getText()))
                .telefonoFijo(txtTelefonoFijo.getText())
                .telefonoCelular(txtCelular.getText())
                .build();
    }


    private void obtenerPorCiudad() {
//        if(!txtCiudadParametro.getText().isEmpty()){
//            String resultado = modelFactory.obtenerClientesPorCiudad(txtCiudadParametro.getText());
//            txtResultadoOperacciones.setText(resultado);
//        }else{
//            txtResultadoOperacciones.setText("El campo esta vacio, es requerido....");
//        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}

