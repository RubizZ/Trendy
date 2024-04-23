package negocio;

import integracion.DAOPedidos;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class BOPedido {

    private final DAOPedidos daoPedidos;

    public BOPedido(DAOPedidos daoPedidos) {
        this.daoPedidos = daoPedidos;
    }

    public void crearPedido(TOACestaUsuario toaCestaUsuario) {
        daoPedidos.añadirPedido(toaCestaUsuario);
    }

    public Collection<TOPedido> getAllPedidos() {
        return daoPedidos.getAllPedidos();
    }

    public Collection<TOPedido> getPedidosUsuario(int IDUsuario) {
        return daoPedidos.getPedidosUsuario(IDUsuario);
    }

    public Collection<TOPedido> getPedidosStatus(TOStatusPedido TOStatusPedido) {
        return daoPedidos.getAllPedidos().stream().filter(pedido -> Objects.equals(pedido.getStatus(), TOStatusPedido.toString())).toList();
    }

    public Collection<TOPedido> getPedidosFecha(Date fecha) {
        return daoPedidos.getAllPedidos().stream().filter(pedido -> Objects.equals(pedido.getFecha(), fecha.toString())).toList();
    }

    public void cambiarStatus(int ID, TOStatusPedido statusPedido) {
        daoPedidos.cambiarStatus(ID, statusPedido);
    }

    public void cancelarPedido(int ID) {
        daoPedidos.cambiarStatus(ID, TOStatusPedido.CANCELADO);
    }

}
