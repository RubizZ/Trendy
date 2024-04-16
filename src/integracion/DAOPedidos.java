package integracion;

import negocio.TOPedido;

import java.util.Collection;

public interface DAOPedidos {
    void añadirPedido(TOPedido toPedido);

    TOPedido getPedido(int ID);

    Collection<TOPedido> getAllPedidos();

    Collection<TOPedido> getPedidosUsuario(int IDUsuario);

    void cambiarStatus(int ID, String status);

    TOPedido getLastPedido();
}
