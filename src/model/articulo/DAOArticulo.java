package model.articulo;

import java.sql.SQLException;

public interface DAOArticulo {

    public tArticulo buscarArticulo(int id) throws SQLException;
    public void altaArticulo(tArticulo a);
    public void bajaArticulo(tArticulo a);

    public void modificarArticulo(tArticulo a);

}
