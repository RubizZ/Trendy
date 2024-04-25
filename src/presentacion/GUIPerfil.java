package presentacion;

import negocio.SAUsuarioImp;
import negocio.TUsuario;

import javax.swing.*;
import java.awt.*;

public class GUIPerfil extends JPanel {

    private SAUsuarioImp saUsuario;
    private TUsuario tUsuario;

    public GUIPerfil(SAFachade fachade){
        saUsuario = fachade;
        initGUI();
    }

    private void initGUI() {
        //TODO no se como sacar el nombre del usuario aqui
        JPanel mainPanel = new JPanel();

        //PANEL QUE SE VA A MOSTRAR AL PRINCIPIO
        JPanel panelIni = new JPanel();
        panelIni.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JLabel nombre = new JLabel();//aqui quiero poner el nombre y apellidos del usuario logeado
        panelIni.add(nombre);

        //PANEL DE MODIFICAR DATOS


        //BOTON PARA MODIFICAR DATOS
        JButton mod_datos = new JButton("Modificar datos");
        mod_datos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(mod_datos);

        //BOTON PARA VER MIS PEDIDOS
        JButton ver_pedidos = new JButton("Ver mis pedidos");
        ver_pedidos.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(ver_pedidos);

        //BOTON PARA ACTUALIZAR LA SUSCRIPCION
        JButton act_suscripcion = new JButton("Actualizar suscripcion");
        act_suscripcion.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelIni.add(act_suscripcion);
    }
}
