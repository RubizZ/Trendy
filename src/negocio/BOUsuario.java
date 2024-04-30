package negocio;

import integracion.DAOImpUsuario;
import integracion.DAOUsuario;

import java.util.Collection;
import java.util.Observable;

public class BOUsuario extends Observable {
    private DAOUsuario daoUsuario = new DAOImpUsuario();
    private TUsuario tUsuario;

    public BOUsuario(DAOUsuario daoUsuario){
        this.daoUsuario = daoUsuario;
    }

    public TUsuario create(TUsuario tUsuario) {
        this.tUsuario = daoUsuario.crearUsuario(tUsuario);
        return this.tUsuario;
    }

    public TUsuario read() {
        this.tUsuario = daoUsuario.getUsuario(tUsuario.getCorreo_e(), tUsuario.getContrasenya());
        return this.tUsuario;
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

    public void actualizarSaldo(double cantidad){ daoUsuario.actualizarSaldo(tUsuario.getId(), cantidad); }
    public void OnHacerPedido(int idCesta){
        daoUsuario.actualizarCesta(tUsuario.getId(), idCesta);
    }

    public void actualizarSuscr(int id) {
        daoUsuario.actualizarSuscripcion(tUsuario.getId(), id);
    }
}
