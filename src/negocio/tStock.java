package negocio;

public class tStock {

    int id;
    String color;
    String talla;
    int stock;

    public tStock(int id, String color, String talla, int stock){
        this.id = id;
        this.color = color;
        this.talla = talla;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
