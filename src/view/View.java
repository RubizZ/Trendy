package view;

import model.articulo.Articulo;
import model.articulo.ArticuloAbstracto;

import java.util.Date;
import java.util.List;

public class View  {

    public void imprimirProducto(Articulo a){

        System.out.println("_______________________");
        if(a.getCategoria() == Articulo.Categoria.EXCLUSIVOS) {
            if(a.haSalido()) System.out.println("Ya a la venta!");
            else System.out.println(a.getFechaLanzamiento());
        }
        System.out.println(a.getName());
        if(a.getDescuento() != 0){
            System.out.println("Precio: "+ (a.getPrecio() - ((a.getDescuento()/100) * a.getPrecio()))+" €" + "  Descuento: " + a.getDescuento() + "%") ;
        }
        else System.out.println("Precio: " +a.getPrecio()+" €");

        System.out.println("ID: " + a.getID()+"  "+ "Color: " + a.getColor().toString());
        System.out.println("Categoria: " + a.getCategoria().toString() + "   Subcategoria: " +  a.getSubcategoria().toString());
        System.out.println("Stock: "+ a.getStock());
    }

    public void imprimeListaCategoria(List<Articulo> l){
        for(Articulo a: l){
            System.out.println(a.getName());
        }
    }
}