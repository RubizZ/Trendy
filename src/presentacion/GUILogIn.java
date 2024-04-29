package presentacion;

import negocio.SAUsuarioImp;
import negocio.TUsuario;
import utils.ViewUtils;

import javax.swing.*;
import java.awt.*;


public class GUILogIn extends JDialog {

    private SAUsuarioImp saUsuario;
    JButton _enter, _cancel, _register, _forgotPassword;

    private JPanel mainPanel;

    JTextField _user, _contrasenya;

    public GUILogIn(){
        initGUI();
    }

    public void initGUI(){

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel user = new JLabel("Usuario: ");
        user.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(user);

        this._user = new JTextField();
        this._user.setAlignmentX(CENTER_ALIGNMENT);
        this._user.setToolTipText("Introduzca su usuario");
        mainPanel.add(this._user);

        JLabel contrasenya = new JLabel("Contraseña: ");
        contrasenya.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(contrasenya);

        this._contrasenya = new JTextField();
        this._contrasenya.setAlignmentX(CENTER_ALIGNMENT);
        this._contrasenya.setToolTipText("Introduzca su contraseña");
        mainPanel.add(this._contrasenya);

        this._enter = new JButton("Entrar");
        this._enter.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(this._enter);

        this._cancel = new JButton("Cancelar");
        this._cancel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(this._cancel);

        this._register = new JButton("Registrarse");
        this._register.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(this._register);

        this._forgotPassword = new JButton("¿Has olvidado tu contraseña?");
        this._forgotPassword.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(this._forgotPassword);

        this._enter.addActionListener(e -> {
           //TUsuario loginUser = crearUsuario();
            TUsuario TransferUsuario = saUsuario.getUsuario();
            if(TransferUsuario == null)
                JOptionPane.showMessageDialog(null, "Usuario o  contraseña no existente");
            else
                ViewUtils.quit(this);
        });

        this._cancel.addActionListener(e -> {
            ViewUtils.quit(this);
        });

        this._register.addActionListener(e -> {
            GUIUserRegister guiUserRegister = new GUIUserRegister(this);
            guiUserRegister.setVisible(true);
        });

        this._forgotPassword.addActionListener(e -> {
            GUIForgotPassword guiForgotPassword = new GUIForgotPassword();
            guiForgotPassword.setVisible(true);
        });
    }

    private TUsuario crearUsuario(){
        TUsuario tUsuario = new TUsuario();
        tUsuario.setCorreo_e(_user.getText());
        tUsuario.setContrasenya(_contrasenya.getText());
        return tUsuario;
    }

    public void open(Frame parent){
        setLocation(//
                parent.getLocation().x + parent.getWidth() / 2 - getWidth() / 2, //
                parent.getLocation().y + parent.getHeight() / 2 - getHeight() / 2);
        pack();
        setVisible(true);
    }

}
