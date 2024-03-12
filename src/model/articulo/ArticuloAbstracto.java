package model.articulo;

public class ArticuloAbstracto implements Articulo {

    private int ID;
    private String name;
    private double precio;
    private Color color;
    private int stock;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public int getStock() {
        return stock;
    }
}
