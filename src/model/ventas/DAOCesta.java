package model.ventas;

public interface DAOCesta {
    void añadirCesta(TOCesta toCesta);

    void añadirArticuloACesta(TOCesta toCesta);

    TOCesta getCesta(int ID);
    public void cambiarCantidad(int ID, int cantidad) ;

    }
