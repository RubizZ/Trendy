package negocio;

import java.util.Collection;

public interface SAUsuario {
    public void create(TUsuario tUsuario);
    public TUsuario getUsuario();
    public Collection<TUsuario> readAll();
    public void update(TUsuario tUsuario);
    public void delete (int id);
    public void actualizarSaldo(int cantidad);
    public void actualizarSuscr(int id);
}
