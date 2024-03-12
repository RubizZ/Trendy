package model.articulo;

public class ArticuloEstandar extends ArticuloAbstracto{


    public ArticuloEstandar(int id, double precio, Color color, int stock, Categoria cat, Subcategoria subcat) {
        super(id, precio, color, stock, cat, subcat);
    }

    @Override
    public String getFechaLanzamiento() {
        return "";
    }
}
