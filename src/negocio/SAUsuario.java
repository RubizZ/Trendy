package negocio;

import java.util.Collection;

public interface SAUsuario {
    public boolean create(TUsuario tUsuario);
    public boolean getUsuario();
    public Collection<TUsuario> readAll();
    public void update(TUsuario tUsuario);
    public void delete (int id);
    public void actualizarSaldo(double cantidad);
    public void actualizarSuscr(int id);
}
