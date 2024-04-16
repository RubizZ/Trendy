package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;

public class SAUsuarioImp implements SAUsuario{

    private DAOUsuario daoUsuario = new DAOImpUsuario();

    @Override
    public int create(TUsuario tUsuario) {
        return daoUsuario.crearUsuario(tUsuario);
    }

    @Override
    public TUsuario read(int id) {
        return daoUsuario.getUsuario(Integer.toString(id));
    }

    @Override
    public Collection<TUsuario> readAll() {
        return daoUsuario.buscarUsuarios();
    }

    @Override
    public int update(TUsuario tUsuario) {
        return daoUsuario.actualizarUsuario(tUsuario, tUsuario.getId(), tUsuario.getCorreo_e()
                    , tUsuario.getNombre(), tUsuario.getApellidos(), tUsuario.getPais(), tUsuario.getSexo()
                    , tUsuario.getSuscripcion(), tUsuario.getDireccion(), tUsuario.getSaldo());
    }

    @Override
    public int delete(int id) {
        return daoUsuario.eliminarUsuario(Integer.toString(id));
    }
}
