package negocio;

import java.util.Collection;
import java.util.Date;

public class SAPedidosImp implements SAPedidos {

    private final BusinessDelegate businessDelegate;

    public SAPedidosImp(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }

    @Override
    public void crearPedido() {
        businessDelegate.crearPedido();
    }

    @Override
    public Collection<TOPedido> getAllPedidos() {
        return businessDelegate.getAllPedidos();
    }

    @Override
    public Collection<TOPedido> getPedidosUsuario(int IDUsuario) {
        return businessDelegate.getPedidosUsuario(IDUsuario);
    }

    @Override
    public Collection<TOPedido> getPedidosStatus(TOStatusPedido TOStatusPedido) {
        return businessDelegate.getPedidosStatus(TOStatusPedido);
    }

    @Override
    public Collection<TOPedido> getPedidosFecha(Date fecha) {
        return businessDelegate.getPedidosFecha(fecha);
    }


    @Override
    public void cambiarStatus(int ID, TOStatusPedido TOStatusPedido) {
        businessDelegate.cambiarStatus(ID, TOStatusPedido);
    }

    @Override
    public void cancelarPedido(int ID) {
        businessDelegate.cancelarPedido(ID); //TODO Preguntar cual de los dos es mejor (y si el business delegate deberia tener un metodo cancelarPedido o solo usar cambiarStatus)
        //businessDelegate.cambiarStatus(ID, TOStatusPedido.CANCELADO);
    }

}
