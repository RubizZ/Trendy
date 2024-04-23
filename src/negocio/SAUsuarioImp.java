package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;

public class SAUsuarioImp implements SAUsuario{

    private NUsuario nUsuario = new NUsuario();

    @Override
    public int create(TUsuario tUsuario) {
        return nUsuario.create(tUsuario);
    }

    @Override
    public TUsuario read(TUsuario usuario) {
        return nUsuario.read(usuario);
    }

    @Override
    public Collection<TUsuario> readAll() {
        return nUsuario.readAll();
    }

    @Override
    public int update(TUsuario tUsuario) {
        return nUsuario.update(tUsuario);
    }

    @Override
    public int delete(int id) {
        return nUsuario.delete(id);
    }
}
