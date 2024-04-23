package model.articulo;

public interface NArticulos {

    public tArticulo buscarArticulo(int id);
    public void altaArticulo(tArticulo a, String fechal,String genero, int descuento);
    public void bajaArticulo(tArticulo a);
    public void modificarArticulo(tArticulo a);
}
