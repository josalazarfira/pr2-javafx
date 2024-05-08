package co.edu.uniquindio.parcial2.parcial2.dto;


public record PrestamoDto(
        String numeroPrestamo,
        String fechaPrestamo,
        String fechaEntrega,
        String nombreEmpleado,
        String cedulaEmpleado,
        String nombreCliente,
        String cedulaCliente,
        String nombreObjeto,
        String codigoObjeto
) {
}
