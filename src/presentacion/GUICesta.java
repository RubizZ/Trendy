package presentacion;

import launcher.SAFactory;
import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUICesta extends MainGuiPanel implements CestaObserver{

    SAFacade facade;
    JPanel mainPanel;
    private HashMap<String, JPanel> panelMap;

    public GUICesta(SAFacade saFacade) {
        facade = saFacade;
        panelMap = new HashMap<>();
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
        panelMap.clear();
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
            panelMap.put(art.getIdArticulo()+"", articulo);
        }
        rellenarCesta();
    }

    @Override
    public void onArticuloAdded(TOArticuloEnCesta articulo) {
        JPanel _articulo = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        _articulo.add(new JLabel(articulo.toString()));//nombre¿?
        _articulo.add(new JLabel(articulo.getTalla() + ""));
        _articulo.add(new JLabel(articulo.getCantidad() + ""));
        panelMap.put(articulo.getIdArticulo()+"", _articulo);
        mainPanel.add(_articulo);
    }

    @Override
    public void onArticuloUpdated(TOArticuloEnCesta articulo) {
        //ELIMINAMOS EL PANEL CON LA INFORMACION ANTIGUA
        JPanel eliminar = panelMap.get(articulo.getIdArticulo()+"");
        //CREAMOS UN PANEL CON LOS DATOS DEL ARTICULO CAMBIADOS
        JPanel _articulo = new JPanel(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        _articulo.add(new JLabel(articulo.toString()));//nombre¿?
        _articulo.add(new JLabel(articulo.getTalla() + ""));
        _articulo.add(new JLabel(articulo.getCantidad() + ""));
        panelMap.put(articulo.getIdArticulo()+"", _articulo);
        mainPanel.add(_articulo);
        //TODO no se si tengo que eliminar lo que habia y volver a mater todo o notificar de
        //TODO alguna manera al panel para que se actualice con los cambios

    }

    @Override
    public void onArticuloRemoved(TOArticuloEnCesta articulo) {
        JPanel eliminar = panelMap.get(articulo.getIdArticulo()+"");
        panelMap.remove(eliminar);
        mainPanel.remove(eliminar);
    }

    private void rellenarCesta(){
        for (HashMap.Entry<String, JPanel> entry : panelMap.entrySet()) {
            JPanel panel = entry.getValue();
            mainPanel.add(panel);
        }
    }
}
