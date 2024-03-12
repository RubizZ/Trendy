package model.articulo;

public interface Articulo {
    int getID();
    String getName();
    double getPrecio();
    Color getColor();
    int getStock();
    Categoria getCategoria();
    Subcategoria getSubcategoria();
    String getFechaLanzamiento();

    enum Color{
        BLANCO, NEGRO, MARRON, ROJO, NARANJA, AMARILLO, BEIGE, CARNE, VERDE, AZUL, ROSA, VIOLETA, GRIS;
    }

    enum Categoria{
        HOMBRE, MUJER, EXCLUSIVOS, PROMOCIONES;
    }

    enum Subcategoria{
        CAMISETA, PANTALON, CHAQUETA, SUDADERA, ZAPATOS, BOLSOS, GORRAS, VESTIDOS, FALDAS, CHALECO, CALCETINES, JERSEY;
    }
}
