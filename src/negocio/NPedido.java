package negocio;

import integracion.DAOPedidos;
import integracion.DAOPedidosImp;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class NPedido {

    private DAOPedidos daoPedidos = new DAOPedidosImp();

    public void crearPedido(TOACestaUsuario toaCestaUsuario) {

        TOPedido toPedido = new TOPedido();


        daoPedidos.añadirPedido(toPedido);
    }

    //TODO Meter transform en business objects


    public Collection<TOPedido> getAllPedidos() {
        return daoPedidos.getAllPedidos();
    }


    public Collection<TOPedido> getPedidosUsuario(int IDUsuario) {
        return daoPedidos.getPedidosUsuario(IDUsuario);
    }


    public Collection<TOPedido> getPedidosStatus(BOPedido.Status status) {
        return daoPedidos.getAllPedidos().stream().filter(pedido -> Objects.equals(pedido.getStatus(), status.toString())).toList();
    }


    public Collection<TOPedido> getPedidosFecha(Date fecha) {
        return daoPedidos.getAllPedidos().stream().filter(pedido -> Objects.equals(pedido.getFecha(), fecha.toString())).toList();
    }


    public void cancelarPedido(int ID) {
        daoPedidos.cambiarStatus(ID, String.valueOf(BOPedido.Status.CANCELADO));

    }

}
