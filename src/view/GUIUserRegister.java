package view;

import javax.swing.*;

public class GUIUserRegister extends JPanel {
    JButton _cancel, _createAcount;

    private void initGUI(){
        JLabel nombre = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _nombre = new JTextField();
        this.add(_nombre);

        JLabel apellido = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _apellido = new JTextField();
        this.add(_nombre);

        JLabel contra = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _contra = new JTextField();
        this.add(_nombre);

        JLabel repContra = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _repContra = new JTextField();
        this.add(_nombre);

        JLabel correo = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _correo = new JTextField();
        this.add(_nombre);

        JLabel pais = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _pais = new JTextField();
        this.add(_nombre);

        JLabel fechaNac = new JLabel("Nombre: ");
        this.add(nombre);

        JTextField _fechaNac = new JTextField();
        this.add(_nombre);

        JLabel sexo = new JLabel("Nombre: ");
        this.add(nombre);

        JComboBox<Object> _sexo = new JComboBox<>();
        this.add(_sexo);
    }
}
