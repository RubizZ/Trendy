package model.articulo;

import java.util.List;
import java.util.function.Predicate;

public interface NListas {

    public List<Articulo> buscaArticulosCategoria(String cat);

    public List<Articulo> buscaFiltro(List<Articulo> lista, Predicate<Articulo> pred);
}
