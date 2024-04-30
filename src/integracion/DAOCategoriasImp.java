package integracion;

import negocio.tArticulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DAOCategoriasImp implements DAOCategorias {
    @Override
    public void altaArticuloCat(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();
        ) {
            st.executeUpdate("insert into ClasificacionArticulos values ('" + id + "', '" +
                    cat + "', '" + descuento + "', '" + fechal + "')");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void bajaArticuloCat(int id) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

        ) {

            st.executeUpdate("delete from Artículo where ID = '" + id + "'");

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }

    @Override
    public void modificarArticulo(int id, String fechal, int descuento, String cat) {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();

        ) {
            st.executeUpdate("update Artículo set  ('" + id + "', ''" +
                    "', '" + cat + "'', '" + descuento + "' , '" +
                    fechal + "')");

        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }

    @Override
    public List<String> getCategorias() {
        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select Categoria from ClasificacionArticulos")) {
            List<String> cat = new LinkedList<>();
            while (rs.next()) {
                if(!cat.contains(rs.getString("Categoria"))){
                    cat.add(rs.getString("Categoria"));
                }
            }
            return cat;
        } catch (SQLException e) {
            throw new RuntimeException("Error SQL" + e.getErrorCode(), e);
        }
    }


}
