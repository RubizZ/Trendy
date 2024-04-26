package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;

public class BOUsuario {
    private DAOUsuario daoUsuario = new DAOImpUsuario();

    public void create(TUsuario tUsuario) {
        daoUsuario.crearUsuario(tUsuario);
    }

    public TUsuario read(TUsuario usuario) {
        return daoUsuario.getUsuario(usuario.getCorreo_e(), usuario.getContrasenya());
    }

    public Collection<TUsuario> readAll() {
        return daoUsuario.buscarUsuarios();
    }


    public void update(TUsuario tUsuario) {
        daoUsuario.actualizarUsuario(tUsuario, tUsuario.getId());
    }

    public void delete(int id) {
        daoUsuario.eliminarUsuario(id);
    }
}
