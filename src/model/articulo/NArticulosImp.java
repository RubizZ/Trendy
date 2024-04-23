package model.articulo;

public class NArticulosImp implements NArticulos{

    DAOArticulo dao = new DAOArticuloImp();
    private SACategorias cats = new SACategoriasImp();
    @Override
    public tArticulo buscarArticulo(int id) {
        if(dao.existeArticulo(id)){
            return dao.buscarArticulo(id);
        }
        else return null;
    }

    @Override
    public void altaArticulo(tArticulo a, String fechal, String genero, int descuento) {
        if(!dao.existeArticulo(a.getID())){
            dao.altaArticulo(a);
            cats.altaArticuloCat(a.getID(), fechal, descuento, genero);
        }
    }

    @Override
    public void bajaArticulo(tArticulo a) {
        if(dao.existeArticulo(a.getID())){
            cats.bajaArticuloCat(a.getID());
            dao.bajaArticulo(a);
        }
    }

    @Override
    public void modificarArticulo(tArticulo a) {
        if(dao.existeArticulo(a.getID())){
            dao.modificarArticulo(a);
        }
    }
}
