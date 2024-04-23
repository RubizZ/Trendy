package negocio;

import integracion.DAOPedidos;
import integracion.DAOPedidosImp;
import utils.Direccion;

import java.text.*;
import java.util.Collection;
import java.util.Date;

public class SAPedidosImp implements SAPedidos {
    private DAOPedidos daoPedidos = new DAOPedidosImp();
    @Override
    public void añadirPedido(BOPedido pedido) {
        daoPedidos.añadirPedido(transform(pedido));
    }

    private TOPedido transform(BOPedido pedido){
        TOPedido toPedido = new TOPedido();
        //toPedido.setID(pedido.getID());
        toPedido.setDireccion(pedido.getDireccion().toString());
        toPedido.setIDCesta(pedido.getIdCesta());
        toPedido.setIDUsuario(pedido.getIdUsuario());
        toPedido.setStatus(pedido.getStatus().toString());
        toPedido.setFecha(pedido.getFecha().toString());
        return toPedido;
    }

    private BOPedido transform(TOPedido pedido){
        BOPedido boPedido = new BOPedido();
        boPedido.setID(pedido.getID());
        boPedido.setDireccion(Direccion.parse(pedido.getDireccion()));
        boPedido.setIdCesta(pedido.getIDCesta());
        boPedido.setIdUsuario(pedido.getIDUsuario());
        boPedido.setStatus(BOPedido.Status.valueOf(pedido.getStatus()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            boPedido.setFecha(formatter.parse(pedido.getFecha()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return boPedido;
    }

    @Override
    public Collection<BOPedido> getAllPedidos() {
        return daoPedidos.getAllPedidos().stream().map(this::transform).toList();
    }

    @Override
    public Collection<BOPedido> getPedidosUsuario(int IDUsuario) {
        return daoPedidos.getPedidosUsuario(IDUsuario).stream().map(this::transform).toList();
    }

    @Override
    public Collection<BOPedido> getPedidosStatus(BOPedido.Status status) {
        return daoPedidos.getAllPedidos().stream().map(this::transform).filter(pedido -> pedido.getStatus() == status).toList();
    }

    @Override
    public Collection<BOPedido> getPedidosFecha(Date fecha) {
        return daoPedidos.getAllPedidos().stream().map(this::transform).filter(pedido -> pedido.getFecha() == fecha).toList();
    }

    @Override
    public void cambiarStatus(int ID, BOPedido.Status status) {
        daoPedidos.cambiarStatus(ID, status.toString());
    }

}
