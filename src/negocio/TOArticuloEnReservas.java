package negocio;

public class TOArticuloEnReservas {
    private int idArticulo;
    private int idUsuario;

    public TOArticuloEnReservas(int idArticulo, int idUsuario) {
        this.idArticulo = idArticulo;
        this.idUsuario = idUsuario;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}
