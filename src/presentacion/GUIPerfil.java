package presentacion;

import negocio.SAUsuarioImp;
import negocio.TUsuario;
import utils.ViewUtils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GUIPerfil extends JPanel {

    private SAUsuarioImp saUsuario;
    private TUsuario tUsuario;

    private JTextField _nombre;
    private JTextField _apellidos;
    private JTextField _contrasenya;
    private JTextField _repContrasenya;
    private JTextField _correo;
    private JTextField _pais;
    private JTextField _anyoNac;
    private JTextField _direccion;
    private JPanel mainPanel;

    public GUIPerfil(SAFacade facade){
        saUsuario = facade;
        initGUI();
    }

    private void initGUI() {
        //TODO no se como sacar el nombre del usuario aqui
        mainPanel = new JPanel();

        //PANEL QUE SE VA A MOSTRAR AL PRINCIPIO
        JPanel panelIni = new JPanel();
        panelIni.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JLabel nombre = new JLabel();//aqui quiero poner el nombre y apellidos del usuario logeado
        panelIni.add(nombre);

        //PANEL DE MODIFICAR DATOS
        JPanel panelMod = new JPanel();
        panelMod.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        panelMod.setVisible(false);
        configurarPanelMod(panelIni, panelMod);

        //PANEL DE VER MIS PEDIDOS
        JPanel panelPedidos = new JPanel();
        panelPedidos.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        panelPedidos.setVisible(false);
        configurarPanelPedidos(panelIni, panelPedidos);

        //PANEL DE ACTUALIZAR SUSCRIPCION
        JPanel panelSuscr = new JPanel();
        panelSuscr.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        panelSuscr.setVisible(false);


        //PANEL DE AÑADIR SALDO
        JPanel panelSaldo = new JPanel();
        panelSaldo.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        panelSaldo.setVisible(false);


        //BOTON PARA MODIFICAR DATOS
        JButton mod_datos = new JButton("Modificar datos");
        mod_datos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(mod_datos);
        mod_datos.addActionListener((e -> {
            panelIni.setVisible(false);
            panelMod.setVisible(true);
        }));

        //BOTON PARA VER MIS PEDIDOS
        JButton ver_pedidos = new JButton("Ver mis pedidos");
        ver_pedidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(ver_pedidos);
        ver_pedidos.addActionListener((e -> {
            panelIni.setVisible(false);
            panelPedidos.setVisible(true);
        }));

        //BOTON PARA ACTUALIZAR LA SUSCRIPCION
        JButton act_suscripcion = new JButton("Actualizar suscripcion");
        act_suscripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(act_suscripcion);
        act_suscripcion.addActionListener((e -> {
            panelIni.setVisible(false);
            panelSuscr.setVisible(true);
        }));

        //BOTON PARA AÑADIR SALDO
        JButton add_saldo = new JButton("Añadir saldo");
        add_saldo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(add_saldo);
    }



    private void addJLabel(String text, Container container){
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label);
    }


    private void configurarPanelMod(Container mainPanel, Container modPanel){
        JTextArea texto_ayuda = new JTextArea("Complete todos los campos aunque no los quiera cambiar");
        texto_ayuda.setBackground(getForeground());
        texto_ayuda.setLineWrap(true);
        texto_ayuda.setWrapStyleWord(true);
        texto_ayuda.setEditable(false);

        addJLabel("Nombre", modPanel);
        _nombre = new JTextField();
        _nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        _nombre.setToolTipText("Introduzca su nombre");
        modPanel.add(_nombre);

        addJLabel("Apellidos", modPanel);
        _apellidos = new JTextField();
        _apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        _apellidos.setToolTipText("Intruduzca sus apellidos");
        modPanel.add(_apellidos);

        addJLabel("Contraseña", modPanel);
        _contrasenya = new JTextField();
        _contrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        _contrasenya.setToolTipText("Introduzca una contraseña");
        modPanel.add(_contrasenya);

        addJLabel("Correo", modPanel);
        _correo = new JTextField();
        _correo.setAlignmentX(Component.CENTER_ALIGNMENT);
        _correo.setToolTipText("Introduzca su correo electronico");
        modPanel.add(_correo);

        addJLabel("Pais", modPanel);
        _pais = new JTextField();
        _pais.setAlignmentX(Component.CENTER_ALIGNMENT);
        _pais.setToolTipText("Intruduzca su pais");
        modPanel.add(_pais);

        addJLabel("Direccion", modPanel);
        _direccion = new JTextField();
        _direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        _direccion.setToolTipText("Introduzca su direccion");
        modPanel.add(_direccion);



        JButton _cancel = new JButton("Cancelar");
        _cancel.addActionListener((e) -> {
            modPanel.setVisible(false);
            mainPanel.setVisible(true);
        });
        _cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        modPanel.add(_cancel);

        JButton _confirmar = new JButton("Confirmar");
        _confirmar.addActionListener((e) -> {
            TUsuario usuario = crearUsuario();
            try{
                saUsuario.update(usuario);
            }catch(RuntimeException re){
                throw new RuntimeException("No se han podido actualizar los datos: ");
            }finally{
                modPanel.setVisible(false);
                mainPanel.setVisible(true);
            }
        });
        _confirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        modPanel.add(_confirmar);
    }

    private void configurarPanelPedidos(JPanel mainPanel, JPanel panelPedidos) {
        //TODO creo que solo tengo que hacer una instancia de la tabla de pedidos que tienen
        //que crear javi y ruben
        JButton atras = new JButton("Atras");
        panelPedidos.add(atras);
        atras.addActionListener((e -> {
            mainPanel.setVisible(true);
            panelPedidos.setVisible(false);
        }));
    }

    private void configurarPanelSaldo(JPanel mainPanel, JPanel panelSaldo) {
        JLabel cant = new JLabel("Introduzca la cantidad que desea añadir");
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 200, 5);
        JSpinner sumarASaldo = new JSpinner(spinnerModel);

        JButton atras = new JButton("Atras");
        panelSaldo.add(atras);
        atras.addActionListener((e -> {
            mainPanel.setVisible(true);
            panelSaldo.setVisible(false);
        }));
    }

    private TUsuario crearUsuario(){
        String nombre, apellidos, correo, contrasenya, pais, dir;
        char sexo;
        int anyo;
        nombre = _nombre.getText();
        apellidos = _apellidos.getText();
        correo = _correo.getText();
        contrasenya = _contrasenya.getText();
        anyo = Integer.parseInt(_anyoNac.getText());
        pais = _pais.getText();
        dir = _direccion.getText();
        //TODO pillar el sexo que ya tenia pero no se de donde se saca
        return new TUsuario(nombre, apellidos, correo, contrasenya, anyo, sexo, pais, dir);
    }
}
