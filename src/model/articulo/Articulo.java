package model.articulo;

public interface Articulo {
    int getID();
    String getName();
    double getPrecio();
    Color getColor();
    int getStock();

    enum Color{
        BLANCO, NEGRO, MARRON, ROJO, NARANJA, AMARILLO, BEIGE, CARNE, VERDE, AZUL, ROSA, VIOLETA, GRIS
    }

    enum Genero{
        HOMBRE, MUJER, UNISEX
    }
}
