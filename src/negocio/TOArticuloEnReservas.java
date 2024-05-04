package negocio;

public class TOArticuloEnReservas {
    private final int idArticulo;
    private final int idUsuario;
    private final BOStock.Talla talla;
    private final BOStock.Color color;

    public TOArticuloEnReservas(int idArticulo, int idUsuario, BOStock.Talla talla, BOStock.Color color) {
        this.idArticulo = idArticulo;
        this.idUsuario = idUsuario;
        this.talla = talla;
        this.color = color;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public BOStock.Talla getTalla() {
        return talla;
    }

    public BOStock.Color getColor() {
        return color;
    }
}
