package negocio;

import java.util.List;
import java.util.function.Predicate;

public class SAListasImp extends AbstractSA implements SAListas {


    public SAListasImp(BusinessDelegate b) {
        super(b);
    }

    @Override
    public List<Articulo> buscaArticulosCategoria(String cat) throws Exception {
        return businessDelegate.buscaArticulosCategoria(cat);
    }


    public List<Articulo> buscaFiltro(List<Articulo> lista, Predicate<Articulo> pred) throws Exception {
        return businessDelegate.buscaFiltro(lista, pred);
    }
}
