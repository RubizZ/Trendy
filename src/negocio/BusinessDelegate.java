package negocio;

import java.util.Collection;
import java.util.Date;

public class BusinessDelegate {
    public void crearPedido() {
        //TODO
    }

    public Collection<TOPedido> getAllPedidos() {
        return null; //TODO
    }

    public Collection<TOPedido> getPedidosUsuario(int idUsuario) {
        return null; //TODO
    }

    public Collection<TOPedido> getPedidosStatus(TOStatusPedido toStatusPedido) {
        return null; //TODO
    }

    public Collection<TOPedido> getPedidosFecha(Date fecha) {
        return null; //TODO
    }

    public void cambiarStatus(int id, TOStatusPedido toStatusPedido) {
        //TODO
    }

    public void cancelarPedido(int id) {
        //TODO
    }
}
