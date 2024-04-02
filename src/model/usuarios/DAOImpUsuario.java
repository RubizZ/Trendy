package model.usuarios;

import database.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DAOImpUsuario implements DAOUsuario{
    @Override
    public List<TUsuario> buscarUsuarios() {
        return null;
    }

    @Override
    public TUsuario getUsuario(String id) {
        return null;
    }

    @Override
    public void crearUsuario(TUsuario usuario) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "INSERT INTO Usuarios VALUES ("
                    + usuario.getId()+ ", '"
                    + usuario.getCorreo_e() + "', '"
                    + usuario.getContrasenya() + "', '"
                    + usuario.getNombre() + "', '"
                    + usuario.getApellidos() + "', '"
                    + usuario.getPais() + "', '"
                    + usuario.getSexo() + "', '"
                    + usuario.getSuscripcion() + "', '"
                    + usuario.getDireccion() + "', "
                    + usuario.getSaldo() + ")";
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al crear el usuario");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                //TODO Hacer excepciones
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            //TODO Hacer excepciones
        }

    }

    @Override
    public void actualizarUsuario(Usuario usuario) {

    }

    @Override
    public void eliminarUsuario(Usuario usuario) {

    }
}
