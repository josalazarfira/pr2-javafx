package co.edu.uniquindio.parcial2.parcial2.model.builder;


import co.edu.uniquindio.parcial2.parcial2.model.Cliente;

public class ClienteBuilder {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected String email;
    protected String telefonoFijo;
    protected String telefonoCelular;
    protected String direccion;
    protected int edad;

    public ClienteBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder email(String email) {
        this.email = email;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder telefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder telefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder direccion(String direccion) {
        this.direccion = direccion;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public ClienteBuilder edad(int edad) {
        this.edad = edad;
        return this; // Devuelve la instancia actual de ClienteBuilder
    }

    public Cliente build() {
        return new Cliente(cedula, nombre, apellido, email, telefonoFijo, telefonoCelular, direccion, edad);
    }
}
