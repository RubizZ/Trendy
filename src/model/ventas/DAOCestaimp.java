package model.ventas;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCestaimp implements DAOCesta{
    @Override
    public void añadirCesta(TOCesta toCesta) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "INSERT INTO Cesta VALUES ("
                    + toCesta.getID() + ", "
                    + toCesta.getCantidad() + ", "
                    + toCesta.getIDArticulo() + ")";
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al añadir a la cesta");
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
    public TOCesta getCesta(int ID) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "SELECT * FROM Cesta WHERE Id = " + ID;
            try (Statement statement = connection.createStatement();
                 ResultSet rS = statement.executeQuery(sql)
            ) {
                if (rS.next()) {
                    return new TOCesta(rS.getInt("Id"))
                            .setCantidad(rS.getInt("direccion"))
                            .setIDArticulo(rS.getInt("id_cesta"));
                } else {
                    System.out.println("No se ha encontrado la cesta con ID " + ID);
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
    public void cambiarCantidad(int ID, int cantidad) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "UPDATE Cesta SET cantidad = " + cantidad + " WHERE Id = " + ID;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("No se ha podido modificar la cantidad de la cesta");
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
