package Presentacion;

import model.articulo.Articulo;

public class BorradorControllerArticulo {
    private View artView;
    private Articulo artModel;

    public BorradorControllerArticulo(View view, Articulo model){
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
