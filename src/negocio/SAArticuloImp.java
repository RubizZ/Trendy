package negocio;

public class SAArticuloImp implements SAArticulo{

    BusinessDelegate nart;

    public SAArticuloImp(BusinessDelegate nart){
        this.nart = nart;
    }

    @Override
    public tArticulo buscarArticulo(int id) {
        return nart.buscarArticulo(id);
    }

    @Override
    public void altaArticulo(tArticulo a, String fechal, String genero, int descuento) {
        nart.altaArticulo(a, fechal, genero, descuento);
    }

    @Override
    public void bajaArticulo(tArticulo a) {
        nart.bajaArticulo(a);
    }

    @Override
    public void modificarArticulo(tArticulo a) {
        nart.modificarArticulo(a);
    }


}
