package negocio;

public interface SACesta {
    void addCesta(TOCesta tOcesta);

    TOCesta readCesta(int id);

    void addArticuloACesta(TOCesta tOcesta);

    TOCesta readArticuloEnCesta(int id_cesta, int id_articulo);

}
