package model.pedidos;

import java.io.Serializable;

public class TOPedido implements Serializable {

    private int ID;
    private String direccion;
    private int IDCesta;
    private int IDUsuario;
    private String status;


    public TOPedido(int ID) {
        this.ID = ID;
    }

    //TODO Preguntar si el Transfer Object deberia de poder clonarse
    public TOPedido(TOPedido other, int ID) {
        this(ID);
        direccion = other.direccion;
        IDCesta = other.IDCesta;
        IDUsuario = other.IDUsuario;
        status = other.status;
    }

    public int getID() {
        return ID;
    }

//    public TOPedido setID(int ID) {
//        this.ID = ID;
//        return this;
//    } //TODO Ver que hacer con esto

    public String getDireccion() {
        return direccion;
    }

    public TOPedido setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getIDCesta() {
        return IDCesta;
    }

    public TOPedido setIDCesta(int IDCesta) {
        this.IDCesta = IDCesta;
        return this;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public TOPedido setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TOPedido setStatus(String status) {
        this.status = status;
        return this;
    }
}
