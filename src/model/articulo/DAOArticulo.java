package model.articulo;

public interface DAOArticulo {

    public tArticulo consultarArticulo(int id);
    public void altaArticulo(tArticulo a);
    public void bajaProducto(tArticulo a);

}
