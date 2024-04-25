package presentacion;

import negocio.SAUsuario;
import negocio.SAUsuarioImp;
import negocio.TUsuario;

import javax.swing.*;
import java.awt.*;

public class GUIUserRegister extends JPanel {
    private JButton _cancel;
    private JButton _createAccount;
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel contrasenya;
    private JLabel repContrasenya;
    private JLabel correo;
    private JLabel pais;
    private JLabel anyoNac;
    private JLabel sexo;
    private JLabel direccion;
    private JTextField _nombre;
    private JTextField _apellidos;
    private JTextField _contrasenya;
    private JTextField _repContrasenya;
    private JTextField _correo;
    private JTextField _pais;
    private JTextField _anyoNac;
    private JTextField _direccion;
    private DefaultComboBoxModel<String> sexoModelo;
    private JComboBox<String> comboBoxSexo;
    private SAUsuarioImp saUsuario;
    private TUsuario tUsuario;

    public GUIUserRegister(){
        saUsuario = new SAUsuarioImp();
        initGUI();
    }
    private void initGUI(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        nombre = new JLabel("Nombre: ");
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(nombre);

        _nombre = new JTextField();
        _nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        _nombre.setToolTipText("Introduzca su nombre");
        mainPanel.add(_nombre);

        apellidos = new JLabel("Apellidos: ");
        apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(apellidos);

        _apellidos = new JTextField();
        _apellidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        _apellidos.setToolTipText("Intruduzca sus apellidos");
        mainPanel.add(_apellidos);

        contrasenya = new JLabel("Contraseña: ");
        contrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(contrasenya);

        _contrasenya = new JTextField();
        _contrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        _contrasenya.setToolTipText("Introduzca una contraseña");
        mainPanel.add(_contrasenya);

        repContrasenya = new JLabel("Confirmar contraseña: ");
        repContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(repContrasenya);

        _repContrasenya = new JTextField();
        _repContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        _repContrasenya.setToolTipText("Repita la contraseña anterior");
        mainPanel.add(_repContrasenya);

        correo = new JLabel("Correo: ");
        correo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(correo);

        _correo = new JTextField();
        _correo.setAlignmentX(Component.CENTER_ALIGNMENT);
        _correo.setToolTipText("Introduzca su correo electronico");
        mainPanel.add(_correo);

        pais = new JLabel("Pais: ");
        pais.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(pais);

        _pais = new JTextField();
        _pais.setAlignmentX(Component.CENTER_ALIGNMENT);
        _pais.setToolTipText("Intruduzca su pais");
        mainPanel.add(_pais);

        direccion = new JLabel("Direccion:");
        direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(direccion);

        _direccion = new JTextField();
        _direccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        _direccion.setToolTipText("Introduzca su direccion");
        mainPanel.add(_direccion);

        anyoNac = new JLabel("Año de nacimiento: ");
        anyoNac.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(anyoNac);

        _anyoNac = new JTextField();
        _anyoNac.setAlignmentX(Component.CENTER_ALIGNMENT);
        _anyoNac.setToolTipText("Introduzca su año de nacimiento");
        mainPanel.add(_anyoNac);

        sexo = new JLabel("Sexo: ");
        mainPanel.add(sexo);
        setComboBox();
        comboBoxSexo = new JComboBox<>(sexoModelo);
        comboBoxSexo.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBoxSexo.setToolTipText("Seleccione su sexo");
        mainPanel.add(comboBoxSexo);

        _cancel = new JButton("Cancelar");
        _cancel.addActionListener((e) -> {
            this.setVisible(false);
        });
        _cancel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(_cancel);

        _createAccount = new JButton("Crear cuenta");
        _createAccount.addActionListener((e) -> {
            String contra, contraRep;
            contra = _contrasenya.getText();
            contraRep = _repContrasenya.getText();
            if(contra.equals(contraRep)){
                tUsuario = crearUsuario();
                saUsuario.create(tUsuario);
            }
            else{
                System.out.println("La contraseña no coincide");
            }
        });
        _createAccount.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(_createAccount);
    }

    private void setComboBox() {
        sexoModelo.addElement("M");
        sexoModelo.addElement("F");
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
        sexo = (char) comboBoxSexo.getSelectedItem();
        return new TUsuario(nombre, apellidos, correo, contrasenya, anyo, sexo, pais, dir);
    }

    /*private void addButton(String text, Container container){
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }*/
}
