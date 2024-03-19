package model.pedidos;

import java.io.Serializable;

public class TOPedidos implements Serializable {

    private int ID;
    private String direccion;
    private int IDCesta;
    private int IDUsuario;

    public TOPedidos(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public TOPedidos setID(int ID) {
        this.ID = ID;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public TOPedidos setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getIDCesta() {
        return IDCesta;
    }

    public TOPedidos setIDCesta(int IDCesta) {
        this.IDCesta = IDCesta;
        return this;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public TOPedidos setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
        return this;
    }
}
