package negocio;

import java.util.List;
import java.util.function.Predicate;

public interface SAListas {
    public List<Articulo> buscaArticulosCategoria(String cat) throws Exception;

    public List<Articulo> buscaFiltro(List<Articulo> lista, Predicate<Articulo> pred) throws Exception;
}
