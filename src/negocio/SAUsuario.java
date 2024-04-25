package negocio;

import java.util.Collection;

public interface SAUsuario {
    public void create(TUsuario tUsuario);
    public TUsuario read(TUsuario usuario);
    public Collection<TUsuario> readAll();
    public void update(TUsuario tUsuario);
    public void delete (int id);
}
