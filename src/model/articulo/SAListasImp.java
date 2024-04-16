package model.articulo;

import java.util.ArrayList;
import java.util.List;

public class SAListasImp {

    //SON DE BUSINESS OBJECT
    List<Articulo> listaMujer;
    List<Articulo> listaHombre;
    List<Articulo> listaExclusivos;
    List<Articulo> listaPromociones;

    public SAListasImp(){
        listaMujer=new ArrayList<>();
        listaHombre=new ArrayList<>();
        listaExclusivos=new ArrayList<>();
        listaPromociones=new ArrayList<>();
    }

    public void anadir(SAArticulo art, String cat){
        switch (cat to categoria){
            case MUJER -> listaMujer.add(art);
            case HOMBRE -> listaHombre.add(art);
            case EXCLUSIVOS -> listaExclusivos.add(art);
        }

        //yo lo meteria directamente
        if(art.getDescuento() > 0){
            listaPromociones.add(art);
        }
    }
}
