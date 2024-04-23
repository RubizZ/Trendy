package negocio;

import utils.Direccion;

import java.util.Date;

public class BOPedido {

    public enum Status {
        REPARTO, ENTREGADO, CANCELADO
    }

    private int ID;
    private Direccion direccion;
    private Status status;
    private Date fecha;
    private int idCesta;
    private int idUsuario;

    public int getID() {
        return ID;
    }

    public BOPedido setID(int ID) {
        this.ID = ID;
        return this;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public BOPedido setDireccion(Direccion direccion) {
        this.direccion = direccion;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public BOPedido setStatus(Status status) {
        this.status = status;
        return this;
    }

    public int getIdCesta() {
        return idCesta;
    }

    public BOPedido setIdCesta(int idCesta) {
        this.idCesta = idCesta;
        return this;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public BOPedido setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public Date getFecha() {
        return fecha;
    }

    public BOPedido setFecha(Date fecha) {
        this.fecha = fecha;
        return this;
    }
}
