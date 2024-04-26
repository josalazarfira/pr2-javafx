package co.edu.uniquindio.parcial2.parcial2.dto;

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
