package negocio;

import java.util.Collection;
import java.util.Date;

public class SAPedidosImp implements SAPedidos {
    private NPedido nPedido = new NPedido();
    @Override
    public void crearPedido() {
        nPedido.crearPedido();
    }

    @Override
    public Collection<TOPedido> getAllPedidos() {
        return nPedido.getAllPedidos();
    }

    @Override
    public Collection<TOPedido> getPedidosUsuario(int IDUsuario) {
        return nPedido.getPedidosUsuario(IDUsuario);
    }

    @Override
    public Collection<TOPedido> getPedidosStatus(BOPedido.Status status) {
        return nPedido.getPedidosStatus(status);
    }

    @Override
    public Collection<TOPedido> getPedidosFecha(Date fecha) {
        return nPedido.getPedidosFecha(fecha);
    }

    @Override
    public void cancelarPedido(int ID) {
        nPedido.cancelarPedido(ID);
    }

}
