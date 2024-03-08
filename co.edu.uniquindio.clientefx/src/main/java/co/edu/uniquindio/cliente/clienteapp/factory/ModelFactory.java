package co.edu.uniquindio.cliente.clienteapp.factory;

import co.edu.uniquindio.cliente.clienteapp.model.PrestamoObjeto;

public class ModelFactory {

    private static ModelFactory modelFactory;

    private PrestamoObjeto prestamoObjeto;


    private ModelFactory(){
        prestamoObjeto = new PrestamoObjeto();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }


    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion){
        return prestamoObjeto.crearCliente(cedula,nombre,apellido,email,telefonoFijo,telefonoCelular,direccion);
    }
}
