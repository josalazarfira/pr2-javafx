package co.edu.uniquindio.parcial2.parcial2.factory;


import co.edu.uniquindio.parcial2.parcial2.model.*;

import java.util.List;

public class ModelFactory {

    private static ModelFactory modelFactory;

    private PrestamoObjeto prestamoUq;


    private ModelFactory(){
        prestamoUq = new PrestamoObjeto();
        inicializarDatos();
    }

    public static ModelFactory getInstancia() {
        if(modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void inicializarDatos() {
        initClientes();
        initEmpleados();
        initObjetos();
        initPrestamos();
    }

    private void initPrestamos() {
        Prestamo prestamo1 = new Prestamo();
        prestamo1.setNumeroPrestamo("PR-1");
        prestamo1.setClienteAsociado(prestamoUq.getListaClientes().get(0));
        prestamo1.setEmpleadoAsociado(prestamoUq.getListaEmpleados().get(0));
        prestamo1.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(0));
        prestamo1.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(2));

        Prestamo prestamo2 = new Prestamo();
        prestamo2.setNumeroPrestamo("PR-2");
        prestamo2.setClienteAsociado(prestamoUq.getListaClientes().get(1));
        prestamo2.setEmpleadoAsociado(prestamoUq.getListaEmpleados().get(1));
        prestamo2.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(1));
        prestamo2.getListaObjetosAsociados().add(prestamoUq.getListaObjetos().get(2));

        prestamoUq.getListaPrestamos().add(prestamo1);
        prestamoUq.getListaPrestamos().add(prestamo2);
    }


    private void initEmpleados() {
        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setCedula("1098");
        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Pedro");
        empleado2.setCedula("1099");
        prestamoUq.getListaEmpleados().add(empleado);
        prestamoUq.getListaEmpleados().add(empleado2);
    }

    private void initObjetos() {
        Objeto objeto1 = new Objeto();
        objeto1.setNombre("Pala");
        objeto1.setIdObjeto("001");
        Objeto objeto2 = new Objeto();
        objeto2.setNombre("Machete");
        objeto2.setIdObjeto("002");
        Objeto objeto3 = new Objeto();
        objeto3.setNombre("Taladro");
        objeto3.setIdObjeto("003");
        prestamoUq.getListaObjetos().add(objeto1);
        prestamoUq.getListaObjetos().add(objeto2);
        prestamoUq.getListaObjetos().add(objeto3);
    }

    private void initClientes() {
        Cliente cliente1 = Cliente.builder()
                .cedula("1094")
                .nombre("juan")
                .apellido("arias")
                .direccion("armenia")
                .edad(17)
                .build();

        Cliente cliente2 = Cliente.builder()
                .cedula("1095")
                .nombre("Ana")
                .apellido("cardenas")
                .direccion("quimbaya")
                .edad(25)
                .build();

        Cliente cliente3 = Cliente.builder()
                .cedula("1096")
                .nombre("Pedro")
                .apellido("perez")
                .direccion("armenia")
                .edad(40)
                .build();

        prestamoUq.getListaClientes().add(cliente1);
        prestamoUq.getListaClientes().add(cliente2);
        prestamoUq.getListaClientes().add(cliente3);
    }


    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion){
        return prestamoUq.crearCliente(cedula,nombre,apellido,email,telefonoFijo,telefonoCelular,direccion);
    }

    public boolean crearCliente(Cliente cliente){
        return prestamoUq.crearCliente(cliente);
    }

    public String obtenerClientesPorCiudad(String ciudad) {
        return prestamoUq.obtenerClientesPorCiudad(ciudad);
    }

    public List<Cliente> obtenerClientes() {
        return prestamoUq.getListaClientes();
    }

    public String obtenerObjetosPrestados(String rango) {
        return prestamoUq.obtenerObjetosPrestados(rango);
    }
}
