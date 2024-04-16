package model.articulo;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCategoriasImp implements DAOCategorias{
    @Override
    public void altaArticuloCat(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

             ResultSet rs = st.executeQuery("insert into ClasificacionArticulos values ("+id+", " +
                     cat +", "+ descuento+", "+fechal+")")
        ) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bajaArticuloCat(int id) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

             ResultSet rs = st.executeQuery("delete from Artículo where ID = "+id+"")) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modificarArticulo(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

             ResultSet rs = st.executeQuery("update Artículo set  (" + id + ", "+
                      ", "+cat+", "+descuento+" , "+
                     fechal+")")) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
