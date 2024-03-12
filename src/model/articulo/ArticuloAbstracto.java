package model.articulo;

public abstract class ArticuloAbstracto implements Articulo {
    private int ID;
    private String name;
    private double precio;
    private Color color;
    private int stock;
    private Categoria cat;
    private Subcategoria subcat;

    public ArticuloAbstracto(int id, double precio, Color color, int stock, Categoria cat, Subcategoria subcat){
        this.ID = id;
        this.precio = precio;
        this.color = color;
        this.stock = stock;
        this.cat = cat;
        this.subcat = subcat;
    }

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

    public Categoria getCategoria() {
        return cat;
    }

    public Subcategoria getSubcategoria() {
        return subcat;
    }

    public abstract String getFechaLanzamiento();
}
