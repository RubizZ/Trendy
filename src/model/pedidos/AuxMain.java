package model.pedidos;

public class AuxMain {
    public static void main(String[] args) {
        DAOPedidos daoPedidos = new DAOPedidosImp();

        TOPedido toPedido = daoPedidos.getPedido(1);
        TOPedido newToPedido = new TOPedido(toPedido, 3);
        daoPedidos.añadirPedido(newToPedido);
        daoPedidos.cambiarStatus(3, "cancelado");
    }
}
