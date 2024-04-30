package presentacion;

import launcher.SAFactory;
import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class GUICesta extends MainGuiPanel implements CestaObserver{

    SAFacade facade;
    JPanel mainPanel;
    public GUICesta(SAFacade saFacade) {
        facade = saFacade;
        initGui();
    }

    private void initGui() {

        mainPanel = new JPanel(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



        mainPanel.setOpaque(true);

        this.setViewportView(mainPanel);

        //TODO mirar porque creo que cuando herede de JScrollPane no va a funcionar
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);*/
    }

    @Override
    public void onCestaChanged(TOCesta cesta) {
        mainPanel.removeAll();//elimino lo antiguo
        TreeSet<TOArticuloEnCesta> lista = (TreeSet<TOArticuloEnCesta>) cesta.getListaArticulos();
        Iterator<TOArticuloEnCesta> art_it = lista.iterator();
        TOArticuloEnCesta art;
        //TODO ver como elimino un panel del mainpanel, no se si puedo tenerlo con una clave asociada o qué
        while(art_it.hasNext()){
            art = art_it.next();
            JPanel articulo = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
            articulo.add(new JLabel(art.toString()));//nombre¿?
            articulo.add(new JLabel(art.getTalla() + ""));
            articulo.add(new JLabel(art.getCantidad() + ""));
            mainPanel.add(articulo);
        }
    }

    @Override
    public void onArticuloAdded(TOArticuloEnCesta articulo) {

    }

    @Override
    public void onArticuloUpdated(TOArticuloEnCesta articulo) {

    }

    @Override
    public void onArticuloRemoved(TOArticuloEnCesta articulo) {

    }
}
