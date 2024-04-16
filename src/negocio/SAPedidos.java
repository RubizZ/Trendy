package negocio;

import java.util.Collection;
import java.util.Date;

public interface SAPedidos {
    void añadirPedido(BOPedido boPedido);

    Collection<BOPedido> getAllPedidos();

    Collection<BOPedido> getPedidosUsuario(int IDUsuario);

    Collection<BOPedido> getPedidosStatus(BOPedido.Status status);

    Collection<BOPedido> getPedidosFecha(Date fecha);

    void cambiarStatus(int ID, BOPedido.Status status);
}
