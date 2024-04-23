package view;

import javax.swing.*;

public class GUIUserRegister extends JPanel {
    private JButton _cancel;
    private JButton _createAccount;
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel contrasenya;
    private JLabel repContrasenya;
    private JLabel correo;
    private JLabel pais;
    private JLabel fechaNac;
    private JLabel sexo;
    private JTextField _nombre;
    private JTextField _apellidos;
    private JTextField _contrasenya;
    private JTextField _repContrasenya;
    private JTextField _correo;
    private JTextField _pais;
    private JTextField _fechaNac;
    private DefaultComboBoxModel<String> sexoModelo;

    private void initGUI(){
        nombre = new JLabel("Nombre: ");
        this.add(nombre);

        _nombre = new JTextField();
        this.add(_nombre);

        apellidos = new JLabel("Apellidos: ");
        this.add(apellidos);

        _apellidos = new JTextField();
        this.add(_apellidos);

        contrasenya = new JLabel("Contraseña: ");
        this.add(contrasenya);

        _contrasenya = new JTextField();
        this.add(_contrasenya);

        repContrasenya = new JLabel("Confirmar contraseña: ");
        this.add(repContrasenya);

        _repContrasenya = new JTextField();
        this.add(_repContrasenya);

        correo = new JLabel("Correo: ");
        this.add(correo);

        _correo = new JTextField();
        this.add(_correo);

        pais = new JLabel("Pais: ");
        this.add(pais);

        _pais = new JTextField();
        this.add(_pais);

        fechaNac = new JLabel("Fecha de nacimiento: ");
        this.add(fechaNac);

        _fechaNac = new JTextField();
        this.add(_fechaNac);

        sexo = new JLabel("Sexo: ");
        this.add(sexo);
        setComboBox();
        JComboBox<String> comboBoxSexo = new JComboBox<>(sexoModelo);
        this.add(comboBoxSexo);
    }

    private void setComboBox() {
        sexoModelo.addElement("M");
        sexoModelo.addElement("F");
    }
}
