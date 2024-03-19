package model.pedidos;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPedidosImp implements DAOPedidos {

    @Override
    public void añadirPedido(TOPedido toPedido) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "INSERT INTO Pedidos VALUES ("
                    + toPedido.getID() + ", '"
                    + toPedido.getDireccion() + "', "
                    + toPedido.getIDCesta() + ", "
                    + toPedido.getIDUsuario() + ", '"
                    + toPedido.getStatus() + "')";
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
                    return new TOPedido(rS.getInt("Id"))
                            .setDireccion(rS.getString("direccion"))
                            .setIDCesta(rS.getInt("id_cesta"))
                            .setIDUsuario(rS.getInt("id_usuario"))
                            .setStatus(rS.getString("status"));
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
}
