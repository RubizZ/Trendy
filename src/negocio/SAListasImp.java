package negocio;

import java.util.*;
import java.util.function.Predicate;

public class SAListasImp implements SAListas {

    BusinessDelegate nlistas;

    public SAListasImp(BusinessDelegate b){
        nlistas = b;
    }

    @Override
    public List<Articulo> buscaArticulosCategoria(String cat) {
        return nlistas.buscaArticulosCategoria(cat);
    }


    public List<Articulo> buscaFiltro(List<Articulo> lista, Predicate<Articulo> pred){
        return nlistas.buscaFiltro(lista, pred);
    }
}
