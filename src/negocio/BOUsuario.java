package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;

public class BOUsuario {
    private DAOUsuario daoUsuario = new DAOImpUsuario();
    private TUsuario tUsuario;

    public BOUsuario(DAOUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public void create(TUsuario tUsuario) {
        daoUsuario.crearUsuario(tUsuario);
    }

    public TUsuario read() {
        return daoUsuario.getUsuario(tUsuario.getCorreo_e(), tUsuario.getContrasenya());
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

    public void actualizarCesta(int cantidad){ daoUsuario.actualizarCesta(tUsuario.getId(), cantidad); }
    public void OnHacerPedido(int idCesta){
        daoUsuario.actualizarCesta(tUsuario.getId(), idCesta);
    }
}
