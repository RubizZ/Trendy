package model.ventas;

public class BOCesta {
    private int ID;

    private int cantidad;

    private int IDArticulo;

    private int IDUsuario;





    public BOCesta(BOCesta other, int ID) {

        this(ID);

        cantidad = other.cantidad;
        IDArticulo = other.IDArticulo;
        IDUsuario = other.IDUsuario;

    }

    public int getID() {
        return ID;
    }

    public BOCesta setID(int id){
        this.ID = id;
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
