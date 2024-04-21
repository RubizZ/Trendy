package model.articulo;

import java.util.ArrayList;
import java.util.List;

public class SAListasImp implements SAListas{

    //PLAN
    /*

    Cogemos las listas de la tabla de categorias join arituclo -> las listas son de articulo
    Luego al mostrar un artículo (en view) llamaremos a la tabla para ver su fecha lanzamiento y descuento


     */



    //SON DE BUSINESS OBJECT
    List<Articulo> listaMujer;
    List<Articulo> listaHombre;
    List<Articulo> listaExclusivos;
    List<Articulo> listaPromociones;

    DAOListas dao = new DAOListasImp();
    DAOArticulo daoArt = new DAOArticuloImp();

    public SAListasImp(){
        listaMujer=new ArrayList<>();
        listaHombre=new ArrayList<>();
        listaExclusivos=new ArrayList<>();
        listaPromociones=new ArrayList<>();
    }

    private List<Articulo> buscaLista(String cat){
        switch (cat.toUpperCase()){
            case "MUJER":
                return this.listaMujer;
            case "HOMBRE":
                return this.listaHombre;
            case "EXCLUSIVOS":
                return this.listaExclusivos;
            case "PROMOCIONES":
                return this.listaPromociones;
            default:
                return null;
        }
    }

    @Override
    public List<Articulo> buscaArticulosCategoria(String cat) {
        List<Integer> tLista = dao.buscaArticulosCategoria(cat);

        List<Articulo> lista = buscaLista(cat);

        for(int id : tLista){
            lista.add(new Articulo(daoArt.buscarArticulo(id)));
        }

        return lista;
    }
}
