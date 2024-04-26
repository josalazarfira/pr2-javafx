package co.edu.uniquindio.cliente.clienteapp.dto;

public record ClienteDto(
        String cedula,
        String nombre,
        String apellido,
        String email,
        String telefonoFijo,
        String telefonoCelular,
        String direccion,
        int edad,
        int numeroPrestamos
) {
}
