package integracion;

import database.DBConnection;
import negocio.TOPedido;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DAOPedidosImp implements DAOPedidos {

    @Override
    public void añadirPedido(TOPedido toPedido) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "INSERT INTO Pedidos VALUES ("
                    + "last_insert_id()" + ", '"
                    + toPedido.getDireccion() + "', "
                    + toPedido.getIDCesta() + ", "
                    + toPedido.getIDUsuario() + ", '"
                    + toPedido.getStatus() + "', '"
                    + toPedido.getFecha() + "')";
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al añadir el pedido");
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
    public TOPedido getPedido(int ID) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Pedidos WHERE Id = " + ID;
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                if (rS.next()) {
                    return new TOPedido()
                            .setID(rS.getInt("Id"))
                            .setDireccion(rS.getString("direccion"))
                            .setIDCesta(rS.getInt("id_cesta"))
                            .setIDUsuario(rS.getInt("id_usuario"))
                            .setStatus(rS.getString("status"))
                            .setFecha(rS.getString("fecha"));
                } else {
                    System.out.println("No se ha encontrado el pedido con ID " + ID);
                }
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                //TODO Hacer excepciones
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            //TODO Hacer excepciones
        }
        return null; //TODO Cambiar y hacer excepciones
    }

    @Override
    public Collection<TOPedido> getAllPedidos() {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Pedidos";
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                List<TOPedido> pedidos = new ArrayList<>();
                while (rS.next()) {
                    pedidos.add(new TOPedido()
                            .setID(rS.getInt("Id"))
                            .setDireccion(rS.getString("direccion"))
                            .setIDCesta(rS.getInt("id_cesta"))
                            .setIDUsuario(rS.getInt("id_usuario"))
                            .setStatus(rS.getString("status"))
                            .setFecha(rS.getString("fecha")));
                }
                return pedidos;
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                //TODO Hacer excepciones
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            //TODO Hacer excepciones
        }
        return null; //TODO Cambiar y hacer excepciones
    }

    @Override
    public Collection<TOPedido> getPedidosUsuario(int IDUsuario) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Pedidos WHERE id_usuario = " + IDUsuario + " ORDER BY Id DESC";
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                List<TOPedido> pedidos = new ArrayList<>();
                while (rS.next()) {
                    pedidos.add(new TOPedido()
                            .setID(rS.getInt("Id"))
                            .setDireccion(rS.getString("direccion"))
                            .setIDCesta(rS.getInt("id_cesta"))
                            .setIDUsuario(rS.getInt("id_usuario"))
                            .setStatus(rS.getString("status"))
                            .setFecha(rS.getString("fecha")));
                }
                return pedidos;
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                //TODO Hacer excepciones
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            //TODO Hacer excepciones
        }
        return null; //TODO Cambiar y hacer excepciones
    }

    @Override
    public void cambiarStatus(int ID, String status) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "UPDATE Pedidos SET status = '" + status + "' WHERE Id = " + ID;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("No se ha podido modificar el estado del pedido");
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
    public TOPedido getLastPedido() {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Pedidos ORDER BY Id DESC LIMIT 1";
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                if (rS.next()) {
                    return new TOPedido()
                            .setID(rS.getInt("Id"))
                            .setDireccion(rS.getString("direccion"))
                            .setIDCesta(rS.getInt("id_cesta"))
                            .setIDUsuario(rS.getInt("id_usuario"))
                            .setStatus(rS.getString("status"))
                            .setFecha(rS.getString("fecha"));
                } else {
                    System.out.println("No se ha encontrado el pedido");
                }
            } catch (SQLException e) {
                System.out.println("Ha habido un error en la base de datos");
                System.out.println("ERROR: " + e.getErrorCode() + " SQLState: " + e.getSQLState() + " Message: " + e.getMessage());
                //TODO Hacer excepciones
            }
        } catch (SQLException e) {
            System.out.println("No se ha podido conectar a la base de datos");
            System.out.println(e.getMessage());
            //TODO Hacer excepciones
        }
        return null; //TODO Cambiar y hacer excepciones
    }
}
