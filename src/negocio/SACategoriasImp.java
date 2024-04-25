package negocio;

public class SACategoriasImp implements SACategorias{

    BOCategorias ncat = new BOCategorias();

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

}
