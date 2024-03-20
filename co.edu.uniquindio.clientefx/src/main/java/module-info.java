module co.edu.uniquindio.cliente.clienteapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.cliente.clienteapp to javafx.fxml;
    exports co.edu.uniquindio.cliente.clienteapp;
    opens co.edu.uniquindio.cliente.clienteapp.viewcontroller;
    exports co.edu.uniquindio.cliente.clienteapp.viewcontroller;

    opens co.edu.uniquindio.cliente.clienteapp.controller;
    exports co.edu.uniquindio.cliente.clienteapp.controller;
//    opens co.edu.uniquindio.cliente.clienteapp.model;
}