import presentacion.Controller;
import view.Productos;

public class Main {
    public static void main(String[] args) {
        Productos view = new Productos();
        Controller controller = new Controller(view);
        controller.mostrarArticulo();
    }
}
