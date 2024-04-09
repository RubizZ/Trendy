package model.articulo;

import java.io.Serializable;

public class tArticulo implements Serializable {

    private int ID;
    private String nombre;
    private double precio;
    private String color;
    private int stock;
    private String cat;
    private String subcat;
    private double descuento;

    private String fechaLanz;

    public tArticulo(int id, String nombre, String cat, String subcat, double precio, String color, int stock,
        String fechalanz, double desc){
        this.ID = id;
        this.nombre = nombre;
        this.cat = cat;
        this.subcat = subcat;
        this.precio = precio;
        this.stock = stock;
        this.color = color;
        this.fechaLanz = fechalanz;
        this.descuento = desc;
    }

    public String getFechaLanz(){
        return this.fechaLanz;
    }

    public void setFechaLanz(String s){
        this.fechaLanz = s;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
