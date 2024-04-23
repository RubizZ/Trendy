package negocio;


import integracion.DAOCesta;
import integracion.DAOCestaimp;

public class SACestaimp implements SACesta{

    private DAOCesta daoCesta = new DAOCestaimp();
    @Override
    public void addCesta(TOCesta tOcesta) {
        daoCesta.añadirCesta(tOcesta);
    }

    @Override
    public TOCesta readCesta(int id) {
        return daoCesta.getCesta(id);
    }

    @Override
    public void addArticuloACesta(TOCesta tOcesta) {
        daoCesta.añadirArticuloACesta(tOcesta);
    }

    @Override
    public TOCesta readArticuloEnCesta(int id_cesta, int id_articulo) {
        return daoCesta.getArticuloEnCesta(id_cesta, id_articulo);
    }
}
