package co.edu.uniquindio.parcial2.parcial2.controller;

import co.edu.uniquindio.parcial2.parcial2.factory.ModelFactory;

public class ReporteController {

    ModelFactory modelFactory;
    public ReporteController() {
        modelFactory = ModelFactory.getInstancia();
    }

    public String obtenerObjetosPrestados(String rango) {
        return modelFactory.obtenerObjetosPrestados(rango);
    }
}
