package integracion;

import database.DBConnection;
import negocio.tArticulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOCategoriasImp implements DAOCategorias{
    @Override
    public void altaArticuloCat(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();
        ) {
            st.executeUpdate("insert into ClasificacionArticulos values ("+id+", " +
                    cat +", "+ descuento+", "+fechal+")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bajaArticuloCat(int id) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

             ) {

            st.executeUpdate("delete from Artículo where ID = "+id+"");

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }

    @Override
    public void modificarArticulo(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

             ) {
            st.executeUpdate("update Artículo set  (" + id + ", "+
                    ", "+cat+", "+descuento+" , "+
                    fechal+")");

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }

    @Override
    public List<String> getCategorias() {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select * from ClasificacionArticulos")) {
            List<String> categorias = new ArrayList<>();
            while (rs.next()) {
                String cat = rs.getString("Categoria");
                if(!categorias.contains(cat)){
                    categorias.add(cat);
                }
            }
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }
}
