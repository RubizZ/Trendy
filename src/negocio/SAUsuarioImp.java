package negocio;

import java.util.Collection;

public class SAUsuarioImp implements SAUsuario{

    private BussinesDelegate bdUsuario = new BussinesDelegate();

    @Override
    public void create(TUsuario tUsuario) {
        bdUsuario.create(tUsuario);
    }

    @Override
    public TUsuario getUsuario() {
        return bdUsuario.read();
    }

    @Override
    public Collection<TUsuario> readAll() {
        return bdUsuario.readAll();
    }

    @Override
    public void update(TUsuario tUsuario) {bdUsuario.update(tUsuario);
    }

    @Override
    public void delete(int id) {bdUsuario.delete(id);
    }

    @Override
    public void actualizarSaldo(int cantidad) {
        bdUsuario.actualizarSaldo(cantidad);
    }

    @Override
    public void actualizarSuscr(int id) {
        bdUsuario.actualizarSusc(id);
    }
}
