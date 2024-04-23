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
                    + toCesta.getIDUsuario() + ")";
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al añadir la cesta");
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
    public void añadirArticuloACesta(TOCesta toCesta) {
        try (Connection connection = DBConnection.connect()) {
            String sql = "INSERT INTO Artículos_en_cesta VALUES ("
                    + toCesta.getID() + ", "
                    + toCesta.getIDArticulo() + ", "
                    + toCesta.getCantidad() + ")";
            try {
                connection.createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Ha habido un error al añadir el articulo a la cesta");
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
                            .setIDUsuario(rS.getInt("ID_Usuario"));
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
    public TOCesta getArticuloEnCesta(int ID_Cesta, int Id_Articulo) {
            try (Connection connection = DBConnection.connect()) {
                String sql = "SELECT * FROM Artículos_en_cesta WHERE ID_Cesta = " + ID_Cesta + "ID_Articulo = " + Id_Articulo;
                try (Statement statement = connection.createStatement();
                     ResultSet rS = statement.executeQuery(sql)
                ) {
                    if (rS.next()) {
                        return new TOCesta(rS.getInt("ID_Cesta"))
                                .setIDArticulo(rS.getInt("ID_Articulo"))
                                .setCantidad(rS.getInt("Cantidad"));
                    } else {
                        System.out.println("No se ha encontrado el articulo con ID " + Id_Articulo + " en la cesta " + ID_Cesta);
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
            String sql = "UPDATE Artículos_en_cesta SET cantidad = " + cantidad + " WHERE Id = " + ID;
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
