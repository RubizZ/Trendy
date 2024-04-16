package negocio;

import java.util.Collection;

public interface SAUsuario {
    public int create(TUsuario tUsuario);
    public TUsuario read(int id);
    public Collection<TUsuario> readAll();
    public int update(TUsuario tUsuario);
    public int delete (int id);
}
