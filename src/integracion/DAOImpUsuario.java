package integracion;

import database.DBConnection;
import negocio.TUsuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOImpUsuario implements DAOUsuario {
    @Override
    public List<TUsuario> buscarUsuarios() {
        List<TUsuario>list = new ArrayList<>();
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Usuarios";
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                while(rS.next()){
                    list.add(new TUsuario( rS.getInt("ID"))
                            .setCorreo_e(rS.getString("correo"))
                            .setContrasenya(rS.getString("contraseña"))
                            .setNombre(rS.getString("nombre"))
                            .setApellidos(rS.getString("apellidos"))
                            .setPais(rS.getString("pais"))
                            .setSexo((char) rS.getString("sexo").getBytes()[0])//TODO revisar si funciona
                            .setSuscripcion(rS.getInt("suscripcion_id"))
                            .setDireccion(rS.getString("Dirección"))
                            .setSaldo(rS.getInt("saldo")));
                }
                return list;
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
    }

    @Override
    public TUsuario getUsuario(String correo, String contrasenya) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Usuarios WHERE correo = '" + correo + "' AND contraseña = '" + contrasenya + "'";
            try (Statement statement = connection.createStatement();
                ResultSet rS = statement.executeQuery(sql)
            ) {
                if(rS.next()){
                    return new TUsuario(rS.getInt("ID"))
                            .setCorreo_e(rS.getString("correo"))
                            .setContrasenya(rS.getString("contraseña"))
                            .setNombre(rS.getString("nombre"))
                            .setApellidos(rS.getString("apellidos"))
                            .setPais(rS.getString("pais"))
                            .setSexo((char) rS.getString("sexo").getBytes()[0])//TODO revisar q funcione esa funcion
                            .setSuscripcion(rS.getInt("suscripcion_id"))
                            .setDireccion(rS.getString("Dirección"))
                            .setSaldo(rS.getInt("saldo"));
                }else{
                    System.out.println("No se ha encontrado ningun usuario con ese correo en la base de datos");
                }
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
        return null;
    }

    @Override
    public int crearUsuario(TUsuario usuario) {
        int succesful = 1;
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
                succesful = 0;
                System.out.println("Ha habido un error al crear el usuario");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            succesful = 0;
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
        return succesful;
    }

    @Override
    public int actualizarUsuario(TUsuario usuario, int ID, String correo, String nombre, String apellidos,
                                  String pais, char sexo, int suscripcion, String direccion, int saldo) {
        int succesful = 1;
        try (Connection connection = DBConnection.connect()) {
            String sql = "UPDATE Usuarios SET ";
            if(correo != null) sql = sql + "correo = '" + correo + "' ";
            if(nombre != null) sql = sql + "nombre = '" + nombre + "'";
            if(apellidos != null) sql = sql + "apellidos = '" + apellidos + "'";
            if(pais != null) sql = sql + "pais = '" + pais + "'";
            if(sexo != ' ') sql = sql + "sexo = '" + sexo + "'"; //si no queremos actualizar el sexo se pone espacio en lugar de null
            if(suscripcion != 0) sql = sql + "suscripcion_id = " + suscripcion;// si no queremos actualizar suscripcion metemos 0 en lugar de null
            if(direccion != null) sql = sql + "direccion = '" + direccion + "'";
            if(saldo != 0) sql = sql + "saldo = " + (usuario.getSaldo()+saldo);
            sql = sql + " WHERE Id = " + ID;
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                succesful = 0;
                System.out.println("Ha habido un error al actualizar el usuario");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            succesful = 0;
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
        return succesful;
    }

    @Override
    public int eliminarUsuario(String ID) {
        int succesfull = 1;
        try (Connection connection = DBConnection.connect()) {
            String sql = "DELETE FROM Usuarios WHERE Id = " + ID;
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al actualizar el usuario");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                succesfull = 0;
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            succesfull = 0;
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
        return succesfull;
    }

    @Override
    public boolean existe(String correo) {
        boolean existe = false;
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Usuarios WHERE correo = '" + correo + "'";
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                if(rS.next()){
                    return true;
                }else{
                    System.out.println("No se ha encontrado el usuario con Id " + correo);
                    return false;
                }
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            throw new RuntimeException("Error SQL " + e.getErrorCode(), e);
        }
    }
}
