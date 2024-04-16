package model.articulo;

import java.util.ArrayList;
import java.util.List;

public class Categorias {
//Las listas NO van en categorías. Como solo lo
// queremos enseñar por pantalla lo que vamos a necesitar es otro transfer.

    List<Articulo> listaMujer;
    List<Articulo> listaHombre;
    List<Articulo> listaExclusivos;
    List<Articulo> listaPromociones;


    public Categorias(){
        listaMujer=new ArrayList<>();
        listaHombre=new ArrayList<>();
        listaExclusivos=new ArrayList<>();
        listaPromociones=new ArrayList<>();
    }


    public void anadir(Articulo art){
        switch (art.getCategoria()){
            case MUJER -> listaMujer.add(art);
            case HOMBRE -> listaHombre.add(art);
            case EXCLUSIVOS -> listaExclusivos.add(art);
        }

        if(art.getDescuento() > 0){
            listaPromociones.add(art);
        }
    }

    /*
    public void altaArticuloCat(int id, String fechal, int descuento, String genero){
        //Lo añado a la tabla
        //Primero veo que categorias tiene, puede pertenecer a varias
        if(descuento != 0){
            dao.altaArticuloCat(id, fechal, descuento, "Promociones");
        }
        if(fechal != ""){
            dao.altaArticuloCat(id, fechal, descuento, "Exclusivos");
        }
        if(genero != ""){
            dao.altaArticuloCat(id, fechal, descuento, genero);
        }
    }

    public void bajaArticuloCat(int id){

    }

*/

}
