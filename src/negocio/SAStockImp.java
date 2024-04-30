package negocio;

public class SAStockImp implements SAStock{

    BusinessDelegate bd;

    public SAStockImp(BusinessDelegate b){
        this.bd = b;
    }

    @Override
    public void altaArticuloStock(tStock s) {
        bd.altaArticuloStock(s);
    }

    @Override
    public void bajaArticuloStock(int id) {
        bd.bajaArticuloStock(id);
    }

    @Override
    public void modificarArticuloStock(tStock s) {
        bd.modificarArticuloStock(s);
    }

    @Override
    public int getStock(int id, String color, String t) {
        return bd.getStock(id, color, t);
    }
}
