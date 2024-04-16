package integracion;

import negocio.TUsuario;

import java.util.List;

public interface DAOUsuario {
    public List<TUsuario> buscarUsuarios();
    public TUsuario getUsuario(String id);
    public int crearUsuario (TUsuario usuario);
    int actualizarUsuario(TUsuario usuario, int ID, String correo, String nombre, String apellidos,
                           String pais, char sexo, int suscripcion, String direccion, int saldo);
    int eliminarUsuario(String ID);
}
