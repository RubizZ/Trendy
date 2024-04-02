package model.usuarios;

import java.util.List;

public interface DAOUsuario {
    public List<TUsuario> buscarUsuarios();
    public TUsuario getUsuario(String id);
    public void crearUsuario (TUsuario usuario);
    public void actualizarUsuario (Usuario usuario);
    public void eliminarUsuario (Usuario usuario);
}
