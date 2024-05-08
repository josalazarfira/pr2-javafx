package co.edu.uniquindio.parcial2.parcial2.model;


import co.edu.uniquindio.parcial2.parcial2.dto.PrestamoDto;

import java.util.ArrayList;
import java.util.List;

public class PrestamoObjeto {

    List<Cliente> listaClientes = new ArrayList<>();
    List<Empleado> listaEmpleados = new ArrayList<>();
    List<Objeto> listaObjetos = new ArrayList<>();
    List<Prestamo> listaPrestamos = new ArrayList<>();

    private String nombre;


    public PrestamoObjeto() {
    }


    public boolean crearCliente(String cedula,
                                String nombre,
                                String apellido,
                                String email,
                                String telefonoFijo,
                                String telefonoCelular,
                                String direccion){
        Cliente clienteEncontrado = obtenerCliente(cedula);
        if(clienteEncontrado == null){
            Cliente cliente = getBuildCliente(cedula, nombre, apellido, email, telefonoFijo, telefonoCelular, direccion);
            getListaClientes().add(cliente);
            return true;
        }else{
            return  false;
        }
    }

    public boolean crearCliente(Cliente nuevoCliente){
        Cliente clienteEncontrado = obtenerCliente(nuevoCliente.getCedula());
        if(clienteEncontrado == null){
            getListaClientes().add(nuevoCliente);
            return true;
        }else{
            return  false;
        }
    }



    private Cliente getBuildCliente(String cedula, String nombre, String apellido, String email, String telefonoFijo, String telefonoCelular, String direccion) {
        return Cliente.builder()
                .nombre(nombre)
                .apellido(apellido)
                .cedula(cedula)
                .direccion(direccion)
                .email(email)
                .telefonoFijo(telefonoFijo)
                .telefonoCelular(telefonoCelular)
                .build();
    }

    private Cliente obtenerCliente(String cedula) {
        Cliente cliente = null;
        for (Cliente cliente1: getListaClientes()) {
            if(cliente1.getCedula().equalsIgnoreCase(cedula)){
                cliente = cliente1;
                break;
            }
        }

        return cliente;
    }


    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Objeto> getListaObjetos() {
        return listaObjetos;
    }

    public void setListaObjetos(List<Objeto> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }

    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }

    public String obtenerClientesPorCiudad(String ciudad) {
        String resultado = "";

        for (Cliente cliente: getListaClientes()) {
            if(cliente.getDireccion().equalsIgnoreCase(ciudad)){
                resultado = resultado + cliente.toString()+ "\n";
            }
        }

        return resultado;
    }

    public String obtenerObjetosPrestados(String rango) {
        String reporte = "";
        int rangoEntero = Integer.parseInt(rango);
        List<Objeto> objetoList = getListaObjetos();
        for (Objeto objeto: objetoList){
            int contador = 0;
            for (Prestamo prestamo: getListaPrestamos()) {
                for (Objeto objetoPrestado: prestamo.getListaObjetosAsociados()) {
                    if(objeto.getIdObjeto().equals(objetoPrestado.getIdObjeto())){
                        contador++;
                    }
                }
            }
            if(contador >= rangoEntero){
                reporte = reporte+objeto.toString()+"\n";
            }
        }
        return reporte;
    }


}
