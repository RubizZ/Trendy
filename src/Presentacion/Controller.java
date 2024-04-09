package Presentacion;


import model.articulo.Articulo;
import Presentacion.View;

public class Controller {

    private View artView;
    private Articulo artModel;

    public Controller(View view, Articulo model){
        this.artView =view;
        this.artModel = model;
    }

    public void mostrarArticulo(){
        artView.imprimirProducto(artModel);
    }

    public void mostrarLista(){
        //artView.
    }

}
