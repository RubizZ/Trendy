package negocio;

import integracion.DAOListas;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class BOListas {
    DAOListas dao;

    public BOListas(DAOListas dao) {
        this.dao = dao;
    }

    public List<Articulo> buscaArticulosCategoria(String cat) throws Exception {
        List<Articulo> lista = dao.buscaArticulosCategoria(cat);
        if (lista.isEmpty()) throw new Exception("No hay ningun articulo que pertenezca a esta categoria");
        return lista;
    }


    public List<Articulo> buscaFiltro(List<Articulo> lista, Predicate<Articulo> pred) throws Exception {
        //Color, precio 3 rangos, subcat
        List<Articulo> filtro = new LinkedList<>();

        for (Articulo a : lista) {
            if (pred.test(a)) {
                filtro.add(a);
            }
        }
        if (filtro.isEmpty()) throw new Exception("No hay articulos con esas caracteristicas");
        return filtro;
    }
}
