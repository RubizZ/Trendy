package model.articulo;

import database.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOListasImp implements DAOListas{
    @Override
    public List<Integer> buscaArticulosCategoria(String cat) {

        try (Connection c = DBConnection.connect();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery("select ID from ClasificacionArticulos where Categoria = cat")) {
            List<Integer> l = new ArrayList<>();
            while (rs.next()) {
                l.add(rs.getInt("ID"));
            }
            return l;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
