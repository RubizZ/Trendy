package model.ventas;

public class BOCesta {
    private int id;

    private int cantidad;

    private int IDArticulo;

    private int IDUsuario;





    public BOCesta(BOCesta other, int ID) {

        id = ID;
        cantidad = other.cantidad;
        IDArticulo = other.IDArticulo;
        IDUsuario = other.IDUsuario;

    }

    public int getID() {
        return id;
    }

    public BOCesta setID(int id){
        this.id = id;
        return this;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BOCesta setCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public int getIDArticulo() {
        return IDArticulo;
    }

    public BOCesta setIDArticulo(int IDArticulo) {
        this.IDArticulo = IDArticulo;
        return this;
    }




}
