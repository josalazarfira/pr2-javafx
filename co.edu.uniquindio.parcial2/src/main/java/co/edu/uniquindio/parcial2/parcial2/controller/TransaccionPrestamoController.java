package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.dto.PrestamoDto;
import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;

import java.util.List;

public class TransaccionPrestamoController {
    ModelFactory modelFactory;

    public TransaccionPrestamoController(){
        modelFactory = ModelFactory.getInstancia();
    }


    public List<PrestamoDto> obtenerPrestamos() {
        return modelFactory.obtenerPrestamos();
    }

    public boolean crearPrestamo(PrestamoDto prestamoDto) {
        return modelFactory.crearPrestamo(prestamoDto);
    }
}
