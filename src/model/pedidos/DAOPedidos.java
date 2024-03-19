package model.pedidos;

public interface DAOPedidos {
    void añadirPedido(TOPedido toPedido);

    TOPedido getPedido(int ID);

    void cambiarStatus(int ID, String status);
}
