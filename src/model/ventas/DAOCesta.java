package model.ventas;

public interface DAOCesta {
    void añadirCesta(TOCesta toCesta);

    void añadirArticuloACesta(TOCesta toCesta);

    TOCesta getCesta(int ID);

    TOCesta getArticuloEnCesta(int ID_Cesta, int ID_Articulo);
    public void cambiarCantidad(int ID, int cantidad) ;

    }
