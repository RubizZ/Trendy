package view;

import javax.swing.*;
import org.json.JSONObject;

public class GUIAdmin extends JPanel{

    private JPanel crearArticulo;
    private JPanel añadirSaldo;
    private JPanel cambiarSuscripcion;
    private JPanel cambiarEstadoPedido;
    private JButton bCrearArticulo, bAñadirSaldo, bCambiarSuscripcion, bCambiarEstadoPedido;
    private SAFacade saFacade;
    public GUIAdmin(){
        initGUI();
    }

    private void initGUI(){

        bCrearArticulo = new JButton("Crear Articulo");
        bCrearArticulo.setAlignmentX(CENTER_ALIGNMENT);
        bCrearArticulo.addActionListener(e -> {
            initCrearArticulo();
        });
        this.add(bCrearArticulo);

        bAñadirSaldo = new JButton("Añadir Saldo");
        bAñadirSaldo.setAlignmentX(CENTER_ALIGNMENT);
        bAñadirSaldo.addActionListener(e -> {
            añadirSaldo = new JPanel();
            añadirSaldo.setVisible(true);
            this.setVisible(false);
        });
        this.add(bAñadirSaldo);

        bCambiarSuscripcion = new JButton("Cambiar Suscripcion");
        bCambiarSuscripcion.setAlignmentX(CENTER_ALIGNMENT);
        bCambiarSuscripcion.addActionListener(e -> {
            cambiarSuscripcion = new JPanel();
            cambiarSuscripcion.setVisible(true);
            this.setVisible(false);
        });
        this.add(bCambiarSuscripcion);

        bCambiarEstadoPedido = new JButton("Cambiar Estado Pedido");
        bCambiarEstadoPedido.setAlignmentX(CENTER_ALIGNMENT);
        bCambiarEstadoPedido.addActionListener(e -> {
            cambiarEstadoPedido = new JPanel();
            cambiarEstadoPedido.setVisible(true);
            this.setVisible(false);
        });
        this.add(bCambiarEstadoPedido);

        //crear articulo
        //añadir saldo
        //cambiar suscripcion
        //cambiar estado pedido
    }

    private void initCrearArticulo(){
        this.crearArticulo = new JPanel();

        JLabel lId = new JLabel("ID: ");
        JTextField tId = new JTextField();

        JLabel lNombre = new JLabel("Nombre: ");
        JTextField tNombre = new JTextField();

        JLabel lPrecio = new JLabel("Precio: ");
        JTextField tPrecio = new JTextField();

        JLabel lColor = new JLabel("Color: ");
        JTextField tColor = new JTextField();

        JLabel lStock = new JLabel("Stock: ");
        JTextField tStock = new JTextField();

        JLabel lSubcategoria = new JLabel("Subcategoria: ");
        JTextField tSubcategoria = new JTextField();

        JButton bCrear = new JButton("Crear");
        bCrear.addActionListener(e -> {
            JSONObject json = new JSONObject();
            json.put("id", tId.getText());
            json.put("nombre", tNombre.getText());
            json.put("precio", tPrecio.getText());
            json.put("color", tColor.getText());
            json.put("stock", tStock.getText());
            json.put("subcategoria", tSubcategoria.getText());


        });

        JButton bCancelar = new JButton("Cancelar");
        bCancelar.addActionListener(e -> {
            crearArticulo.setVisible(false);
            this.setVisible(true);
        });
    }
}
