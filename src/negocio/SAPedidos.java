package negocio;

import java.util.Collection;
import java.util.Date;

public interface SAPedidos {
    void crearPedido();

    Collection<TOPedido> getAllPedidos();

    Collection<TOPedido> getPedidosUsuario(int IDUsuario);

    Collection<TOPedido> getPedidosStatus(BOPedido.Status status);

    Collection<TOPedido> getPedidosFecha(Date fecha);

    void cancelarPedido(int ID);
}
