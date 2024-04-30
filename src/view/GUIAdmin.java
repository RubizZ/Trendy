package view;

import javax.swing.*;

import negocio.SAFacade;
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
            initAñadirSaldo();
        });
        this.add(bAñadirSaldo);

        bCambiarSuscripcion = new JButton("Cambiar Suscripcion");
        bCambiarSuscripcion.setAlignmentX(CENTER_ALIGNMENT);
        bCambiarSuscripcion.addActionListener(e -> {
            initCambiarSuscripcion();
        });
        this.add(bCambiarSuscripcion);

        bCambiarEstadoPedido = new JButton("Cambiar Estado Pedido");
        bCambiarEstadoPedido.setAlignmentX(CENTER_ALIGNMENT);
        bCambiarEstadoPedido.addActionListener(e -> {
            initCambiarEstadoPedido();
        });
        this.add(bCambiarEstadoPedido);

        //crear articulo
        //añadir saldo
        //cambiar suscripcion
        //cambiar estado pedido
    }

    private void initCrearArticulo(){
        this.crearArticulo = new JPanel();
        this.setVisible(false);
        this.crearArticulo.setVisible(true);

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

            saFacade.crearArticulo(json);

        });

        JButton bCancelar = new JButton("Cancelar");
        bCancelar.addActionListener(e -> {
            crearArticulo.setVisible(false);
            this.setVisible(true);
        });
    }

    private void initAñadirSaldo(){
        this.añadirSaldo = new JPanel();
        this.setVisible(false);
        this.añadirSaldo.setVisible(true);

        JLabel lId = new JLabel("ID: ");
        JTextField tId = new JTextField();

        JLabel lSaldo = new JLabel("Saldo: ");
        JTextField tSaldo = new JTextField();

        JButton bAñadir = new JButton("Añadir");
        bAñadir.addActionListener(e -> {
            JSONObject json = new JSONObject();
            json.put("id", tId.getText());
            json.put("saldo", tSaldo.getText());

            saFacade.añadirSaldo(json);
        });

        JButton bCancelar = new JButton("Cancelar");
        bCancelar.addActionListener(e -> {
            añadirSaldo.setVisible(false);
            this.setVisible(true);
        });
    }

    private void initCambiarSuscripcion(){
        this.cambiarSuscripcion = new JPanel();
        this.setVisible(false);
        this.cambiarSuscripcion.setVisible(true);

        JLabel lId = new JLabel("ID: ");
        JTextField tId = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        //TODO hay que añadir todas las subscripciones desde algun lado

        JComboBox<String> cbSuscripcion = new JComboBox<>(model);


        JButton bCambiar = new JButton("Cambiar");
        bCambiar.addActionListener(e -> {
            JSONObject json = new JSONObject();
            json.put("id", tId.getText());
            json.put("suscripcion", cbSuscripcion.getSelectedItem());

            saFacade.cambiarSuscripcion(json);
        });

        JButton bCancelar = new JButton("Cancelar");
        bCancelar.addActionListener(e -> {
            cambiarSuscripcion.setVisible(false);
            this.setVisible(true);
        });
    }

    private void initCambiarEstadoPedido(){
        this.cambiarEstadoPedido = new JPanel();
        this.setVisible(false);
        this.cambiarEstadoPedido.setVisible(true);

        JLabel lId = new JLabel("ID: ");
        JTextField tId = new JTextField();
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        //TODO hay que añadir todos los estados de pedido desde algun lado

        JComboBox<String> cbEstado = new JComboBox<>(model);


        JButton bCambiar = new JButton("Cambiar");
        bCambiar.addActionListener(e -> {
            JSONObject json = new JSONObject();
            json.put("id", tId.getText());
            json.put("estado", cbEstado.getSelectedItem());

            saFacade.cambiaEstadoPedido(json);
        });

        JButton bCancelar = new JButton("Cancelar");
        bCancelar.addActionListener(e -> {
            cambiarEstadoPedido.setVisible(false);
            this.setVisible(true);
        });
    }
}
