package integracion;

import negocio.Articulo;

import java.util.List;

public interface DAOListas {

    public List<Articulo> buscaArticulosCategoria(String cat);
}
