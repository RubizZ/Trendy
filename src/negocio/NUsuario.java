package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;

public class NUsuario {
    private DAOUsuario daoUsuario = new DAOImpUsuario();

    public int create(TUsuario tUsuario) {
        return daoUsuario.crearUsuario(tUsuario);
    }

    public TUsuario read(TUsuario usuario) {
        return daoUsuario.getUsuario(usuario.getCorreo_e(), usuario.getContrasenya());
    }

    public Collection<TUsuario> readAll() {
        return daoUsuario.buscarUsuarios();
    }


    public int update(TUsuario tUsuario) {
        return daoUsuario.actualizarUsuario(tUsuario, tUsuario.getId(), tUsuario.getCorreo_e()
                , tUsuario.getNombre(), tUsuario.getApellidos(), tUsuario.getPais(), tUsuario.getSexo()
                , tUsuario.getSuscripcion(), tUsuario.getDireccion(), tUsuario.getSaldo());
    }

    public int delete(int id) {
        return daoUsuario.eliminarUsuario(Integer.toString(id));
    }
}
