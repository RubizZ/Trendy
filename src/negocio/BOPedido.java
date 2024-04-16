package negocio;

import java.util.Date;

public class BOPedido {

    public enum Status {
        REPARTO, ENTREGADO, CANCELADO
    }
    public record Direccion(Via via, int numero, String ciudad, String provincia, int codigoPostal) {
        public Direccion {
            if (via == null || ciudad == null || provincia == null)
                throw new IllegalArgumentException("Ningún campo de la dirección puede ser nulo");
            if (numero <= 0) throw new IllegalArgumentException("El número de la dirección debe ser mayor que 0");
            if (codigoPostal < 10000 || codigoPostal > 99999)
                throw new IllegalArgumentException("El código postal debe tener 5 dígitos");
        }

        public record Via(TipoVia tipoVia, String nombre) {
            public enum TipoVia {CALLE, AVENIDA, PLAZA, CAMINO, CARRETERA}

            public Via {
                if(tipoVia == null || nombre == null)
                    throw new IllegalArgumentException("Ningún campo de la vía puede ser nulo");
            }
        }

        @Override
        public String toString() {
            return via.tipoVia + " " + via.nombre + ", " + numero + ", " + ciudad + ", " + provincia + ", " + codigoPostal;
        }

        public static Direccion parse(String direccion) {
            String[] parts = direccion.split(", ");
            String[] viaParts = parts[0].split(" ");
            return new Direccion(new Via(Via.TipoVia.valueOf(viaParts[0]), viaParts[1]), Integer.parseInt(parts[1]), parts[2], parts[3], Integer.parseInt(parts[4]));
        }
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
