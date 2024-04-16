package model.articulo;

import java.io.Serializable;
import java.util.List;

public class tListas implements Serializable {

    //No se yo si esto va aqui asi6
    List<Articulo> listaMujer;
    List<Articulo> listaHombre;
    List<Articulo> listaExclusivos;
    List<Articulo> listaPromociones;

    public List<Articulo> getListaMujer() {
        return listaMujer;
    }

    public void setListaMujer(List<Articulo> listaMujer) {
        this.listaMujer = listaMujer;
    }

    public List<Articulo> getListaHombre() {
        return listaHombre;
    }

    public void setListaHombre(List<Articulo> listaHombre) {
        this.listaHombre = listaHombre;
    }

    public List<Articulo> getListaExclusivos() {
        return listaExclusivos;
    }

    public void setListaExclusivos(List<Articulo> listaExclusivos) {
        this.listaExclusivos = listaExclusivos;
    }

    public List<Articulo> getListaPromociones() {
        return listaPromociones;
    }

    public void setListaPromociones(List<Articulo> listaPromociones) {
        this.listaPromociones = listaPromociones;
    }
}
