package integracion;

import negocio.TOArticuloEnCesta;
import negocio.TOArticuloEnFavoritos;
import negocio.TOCesta;

import java.util.Set;

public interface DAOCesta {
    boolean añadirArticulo(TOCesta toCesta, TOArticuloEnCesta toArticuloEnCesta);

    boolean eliminarArticulo(TOCesta toCesta, TOArticuloEnCesta toArticuloEnCesta);

    TOCesta getCesta(int idUsuario);

    Set<TOArticuloEnFavoritos> getFavoritos(int idUsuario);

    void añadirArticuloAFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    void eliminarArticuloDeFavoritos(TOArticuloEnFavoritos toArticuloEnFavoritos);

    int guardaCesta(TOCesta toCesta);

    int abrirCesta(int idUsuario);
}
