package model;

import model.articulo.Articulo;
import model.articulo.ArticuloAbstracto;

import java.util.List;

public interface Persona {
    void anyadirACesta(ArticuloAbstracto a);
    void eliminarDeCesta(ArticuloAbstracto a);
    List<ArticuloAbstracto> pedirCesta();

    void logIn();
}
