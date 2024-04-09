package model.usuarios;

import java.util.List;

public interface DAOUsuario {
    public List<TUsuario> buscarUsuarios();
    public TUsuario getUsuario(String id);
    public void crearUsuario (TUsuario usuario);
    void actualizarUsuario(TUsuario usuario, int ID, String correo, String nombre, String apellidos,
                           String pais, char sexo, int suscripcion, String direccion, int saldo);
    void eliminarUsuario(String ID);
}
