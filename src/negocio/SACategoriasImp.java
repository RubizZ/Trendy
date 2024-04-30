package negocio;

import java.util.List;

public class SACategoriasImp implements SACategorias{

    BusinessDelegate ncat;

    public SACategoriasImp(BusinessDelegate b){
        ncat = b;
    }

    @Override
    public void altaArticuloCat(int id, String fechal, int descuento, String genero) {
        ncat.altaArticuloCat(id, fechal, descuento, genero);
    }

    @Override
    public void bajaArticuloCat(int id) {
        ncat.bajaArticuloCat(id);
    }

    @Override
    public void modificarArticulo(int id, String fechal, int descuento, String genero) {
        ncat.modificarArticulo(id, fechal, descuento, genero);
    }

    @Override
    public List<String> getCategorias() {
        return ncat.getCategorias();
    }

}
