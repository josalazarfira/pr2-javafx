package co.edu.uniquindio.parcial2.parcial2.model;

public class Empleado extends  Persona{
    PrestamoObjeto ownedByPrestamoUq;

    public Empleado() {
    }

    public PrestamoObjeto getOwnedByPrestamoUq() {
        return ownedByPrestamoUq;
    }

    public void setOwnedByPrestamoUq(PrestamoObjeto ownedByPrestamoUq) {
        this.ownedByPrestamoUq = ownedByPrestamoUq;
    }

}
