package model.ventas;

public interface DAOCesta {
    void añadirCesta(TOCesta toCesta);

    TOCesta getCesta(int ID);
}
