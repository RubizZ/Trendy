package negocio;

public interface SACesta {
    void addArticuloACesta(TOArticuloEnCesta toArticuloEnCesta);

    void actualizarArticuloEnCesta(TOArticuloEnCesta toArticuloEnCesta);

    void removeArticuloDeCesta(TOArticuloEnCesta toArticuloEnCesta);

    void addArticuloAFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    void removeArticuloDeFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    void addArticuloAReservas(TOArticuloEnReservas artEnReservas);

    void removeArticuloDeReservas(TOArticuloEnReservas artEnReservas);

    void updateCesta();
}
