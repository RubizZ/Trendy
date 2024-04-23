package negocio;

public class Articulo {

    private int ID;
    private String name;
    private double precio;
    private Color color;
    private int stock;
    private Subcategoria subcat;

    public Articulo(tArticulo a){
        this.ID = a.getID();
        this.name = a.getNombre();
        this.color = stringToColor(a.getColor());
        this.subcat = stringToSubcat(a.getSubcat());
        this.precio = a.getPrecio();
        this.stock = a.getStock();
    }

    enum Color{
        BLANCO, NEGRO, MARRON, ROJO, NARANJA, AMARILLO, BEIGE, VERDE, AZUL, ROSA, VIOLETA, GRIS;
    }


    enum Subcategoria{
        CAMISETA, PANTALON, CHAQUETA, SUDADERA, ZAPATOS, BOLSOS, GORRAS, VESTIDOS, FALDAS, CHALECO, CALCETINES, JERSEY;
    }

    public String colorToString(){
        String c = "";
        switch(this.color){
            case AZUL -> c = "Azul";
            case GRIS -> c = "Gris";
            case ROJO -> c = "Rojo";
            case ROSA -> c = "Rosa";
            case BEIGE -> c = "Beige";
            case NEGRO -> c = "Negro";
            case VERDE -> c = "Verde";
            case BLANCO -> c = "Blanco";
            case MARRON -> c = "Marron";
            case NARANJA -> c = "Naranja";
            case VIOLETA -> c = "Violeta";
            case AMARILLO -> c = "Amarillo";
            default-> c = "";
        }
        return c;
    }


    public String subcategoriaToString(){
        String c = "";
        switch(this.subcat){
            case BOLSOS -> c = "Bolsos";
            case FALDAS -> c = "Faldas";
            case GORRAS -> c = "Gorras";
            case JERSEY -> c = "Jersey";
            case CHALECO -> c = "Chalecos";
            case ZAPATOS -> c = "Zapatos";
            case CAMISETA -> c = "Camisetas";
            case CHAQUETA -> c = "Chaquetas";
            case PANTALON -> c = "Pantalones";
            case SUDADERA -> c = "Sudaderas";
            case VESTIDOS -> c = "Vestidos";
            case CALCETINES -> c = "Calcetines";
            default -> c = "";
        }
        return c;
    }

    public Subcategoria stringToSubcat(String sub){
        Subcategoria c = null;
        switch(sub.toUpperCase()){
            case "BOLSOS" -> c = Subcategoria.BOLSOS;
            case "FALDAS" -> c = Subcategoria.FALDAS;
            case "GORRAS" -> c = Subcategoria.GORRAS;
            case "JERSEY" -> c = Subcategoria.JERSEY;
            case "CHALECO" -> c = Subcategoria.CHALECO;
            case "ZAPATOS" -> c = Subcategoria.ZAPATOS;
            case "CAMISETA" -> c = Subcategoria.CAMISETA;
            case "CHAQUETA" -> c = Subcategoria.CHAQUETA;
            case "PANTALON" -> c = Subcategoria.PANTALON;
            case "SUDADERA" -> c = Subcategoria.SUDADERA;
            case "VESTIDOS" -> c = Subcategoria.VESTIDOS;
            case "CALCETINES" -> c = Subcategoria.CALCETINES;
        }
        return c;
    }

    public Color stringToColor(String color){
        Color c = null;
        switch(color.toUpperCase()){
            case "AZUL" -> c = Color.AZUL;
            case "GRIS" -> c = Color.GRIS;
            case "ROJO" -> c = Color.ROJO;
            case "ROSA" -> c = Color.ROSA;
            case "BEIGE" -> c = Color.BEIGE;
            case "NEGRO" -> c = Color.NEGRO;
            case "VERDE" -> c = Color.VERDE;
            case "BLANCO" -> c = Color.BLANCO;
            case "MARRON" -> c = Color.MARRON;
            case "NARANJA" -> c = Color.NARANJA;
            case "VIOLETA" ->  c = Color.VIOLETA;
            case "AMARILLO" -> c = Color.AMARILLO;
        }

        return c;
    }

}
