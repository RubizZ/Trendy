package integracion;

import negocio.TOArticuloEnCesta;
import negocio.TOArticuloEnFavoritos;
import negocio.TOArticuloEnReservas;
import negocio.TOCesta;

import java.util.Set;

public interface DAOCesta {

    //Cesta
    int abrirCesta(int idUsuario);

    int guardaCesta(TOCesta toCesta);

    TOCesta getCesta(int idUsuario);

    boolean añadirArticulo(TOCesta toCesta, TOArticuloEnCesta toArticuloEnCesta);

    boolean eliminarArticulo(TOCesta toCesta, TOArticuloEnCesta toArticuloEnCesta);

    //Favoritos
    Set<TOArticuloEnFavoritos> getFavoritos(int idUsuario);

    void añadirArticuloAFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    void eliminarArticuloDeFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    //Reservas

    void añadirArticuloAReservas(TOArticuloEnReservas artEnReservas);

    void eliminarArticuloDeReservas(TOArticuloEnReservas artEnReservas);

    Set<TOArticuloEnReservas> getReservas(int idUsuario);

}
