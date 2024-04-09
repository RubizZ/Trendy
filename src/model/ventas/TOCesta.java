package model.ventas;

import java.io.Serializable;

public class TOCesta implements Serializable {

    private int ID;

    private int cantidad;

    private int IDArticulo;

    private int IDUsuario;




    public TOCesta(int ID) {
        this.ID = ID;
    }

    //TODO Preguntar si el Transfer Object deberia de poder clonarse
    public TOCesta(TOCesta other, int ID) {

        this(ID);

        cantidad = other.cantidad;
        IDArticulo = other.IDArticulo;
        IDUsuario = other.IDUsuario;

    }

    public int getID() {
        return ID;
    }

//    public TOPedido setID(int ID) {
//        this.ID = ID;
//        return this;
//    } //TODO Ver que hacer con esto

    public int getCantidad() {
        return cantidad;
    }

    public TOCesta setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public int getIDArticulo() {
        return IDArticulo;
    }

    public TOCesta setIDArticulo(int IDArticulo) {
        this.IDArticulo = IDArticulo;
        return this;
    }

    public int getIDUsuario() {
        return IDUsuario;
    }

    public TOCesta setIDUsuario(int IDUsuario) {
        this.IDUsuario = IDUsuario;
        return this;
    }


}
