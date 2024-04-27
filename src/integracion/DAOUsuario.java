package integracion;

import negocio.TUsuario;

import java.util.List;

public interface DAOUsuario {
    public List<TUsuario> buscarUsuarios();
    public TUsuario getUsuario(String correo, String contrasenya);
    public void crearUsuario (TUsuario usuario);
    void actualizarUsuario(TUsuario usuario, int ID);
    void eliminarUsuario(int ID);
    public boolean existe(String correo);
    int getNuevoId();
    void actualizarCesta(int idUsuario, int idCesta);
    void actualizarSaldo(int idUsuario, int cantidad);
}
