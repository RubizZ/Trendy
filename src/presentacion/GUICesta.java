package presentacion;

import negocio.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class GUICesta extends MainGUIPanel implements CestaObserver, FavsObserver, ReservasObserver, AuthObserver {

    private final GUIWindow mainWindow;
    SAFacade facade;
    JPanel mainPanel;
    private HashMap<TOArticuloEnCesta, JPanel> panelMap;
    private HashMap<TOArticuloEnFavoritos, JPanel> favsMap;
    private HashMap<TOArticuloEnReservas, JPanel> reserMap;
    private JPanel panelCesta;
    private JPanel panelFavs;
    private JPanel panelReservas;

    private static final String PANELCESTA = "Panel_cesta";
    private static final String PANELFAVORITOS = "Panel_favoritos";

    private static final String PANELRESERVAS = "Panel_reservas";

    private JLabel mensajeCesta = new JLabel("La cesta se encuentra vacia...");
    private JLabel mensajeFavs = new JLabel("La lista de favoritos se encuentra vacia...");
    private JLabel mensajesReservas = new JLabel("No hay reservas...");

    private JPanel cards;
    private CardLayout cl;
    private JPanel buttonPanel;

    public GUICesta(SAFacade saFacade, GUIWindow mainWindow) {
        this.facade = saFacade;
        this.mainWindow = mainWindow;
        facade.registerObserver(this);
        panelMap = new HashMap<>();
        favsMap = new HashMap<>();
        reserMap = new HashMap<>();
        initGui();
    }

    private void initGui() {

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setViewportView(mainPanel);
        cards = new JPanel(new CardLayout());

        //CREAMOS PANELES

        //PANEL CESTA
        JPanel panelCestaComprar = new JPanel(new BorderLayout());
        panelCestaComprar.setBorder(BorderFactory.createTitledBorder("Cesta"));

        panelCesta = new JPanel();
        panelCesta.setLayout(new BoxLayout(panelCesta, BoxLayout.Y_AXIS));
        panelCesta.setBorder(BorderFactory.createTitledBorder("Articulos en la cesta"));
        panelCestaComprar.add(panelCesta, BorderLayout.CENTER);

        //PANEL FAVORITOS
        panelFavs = new JPanel();
        panelFavs.setBorder(BorderFactory.createTitledBorder("Favoritos"));
        panelFavs.setLayout(new BoxLayout(panelFavs, BoxLayout.Y_AXIS));
        panelFavs.setVisible(false);

        //PANEL RESERVAS
        panelReservas = new JPanel();
        panelReservas.setBorder(BorderFactory.createTitledBorder("Reservas"));
        panelReservas.setLayout(new BoxLayout(panelReservas, BoxLayout.Y_AXIS));
        panelReservas.setVisible(false);


        // Añadir paneles al panel de cartas
        cards.add(panelCestaComprar, PANELCESTA);
        cards.add(panelFavs, PANELFAVORITOS);
        cards.add(panelReservas, PANELRESERVAS);

        //PARA CAMBIAR LOS PANELES CON LOS ACTION LISTENERS
        cl = (CardLayout) (cards.getLayout());

        //BOTON REALIZAR PEDIDO
        JButton pedir = new JButton("Realizar pedido");
        pedir.setAlignmentX(Component.CENTER_ALIGNMENT);
        pedir.addActionListener((e -> {
            this.facade.crearPedido();
        }));
        panelCestaComprar.add(pedir, BorderLayout.PAGE_END);

        mainPanel.setOpaque(true);
        mainPanel.add(cards, BorderLayout.CENTER);

        this.setViewportView(mainPanel);

    }


    @Override
    public void onCestaChanged(TOCesta cesta) {
        panelCesta.removeAll();//elimino lo antiguo
        panelMap.clear();
        TreeSet<TOArticuloEnCesta> lista = (TreeSet<TOArticuloEnCesta>) cesta.getListaArticulos();
        if (lista.isEmpty()) {
            panelCesta.add(mensajeCesta);
        } else {
            Iterator<TOArticuloEnCesta> art_it = lista.iterator();
            while (art_it.hasNext()) {
                TOArticuloEnCesta art = art_it.next();
                JPanel articulo = new JPanel();
                articulo.setLayout(new BoxLayout(articulo, BoxLayout.X_AXIS));
                articulo.add(new JLabel(facade.buscarArticulo(art.getIdArticulo()).getNombre()));
                articulo.add(new JLabel("/" + art.getTalla()));
                articulo.add(new JLabel("/" + art.getColor()));
                articulo.add(new JLabel("/" + art.getCantidad() + "Uds."));
                addButtons(articulo, art);
                panelMap.put(art, articulo);
                panelCesta.add(articulo);
            }
        }
        panelCesta.revalidate();
        panelCesta.repaint();
    }

    @Override
    public void onArticuloAdded(TOArticuloEnCesta articulo) {
        panelCesta.remove(mensajeCesta);
        addArticuloCesta(articulo);
    }


    public void onArticuloUpdated(TOArticuloEnCesta articulo) {
        //ELIMINAMOS EL PANEL CON LA INFORMACION ANTIGUA
        JPanel eliminar = panelMap.get(articulo);
        panelCesta.remove(eliminar);
        //CREO UN PANEL CON LOS DATOS DEL ARTICULO CAMBIADOS
        addArticuloCesta(articulo);
    }

    private void addArticuloCesta(TOArticuloEnCesta articulo) {
        JPanel _articulo = new JPanel();
        _articulo.setLayout(new BoxLayout(_articulo, BoxLayout.X_AXIS));
        _articulo.add(new JLabel(facade.buscarArticulo(articulo.getIdArticulo()).getNombre()));
        _articulo.add(new JLabel("/" + articulo.getTalla()));
        _articulo.add(new JLabel("/" + articulo.getColor()));
        _articulo.add(new JLabel("/" + articulo.getCantidad() + "Uds.")); //TODO Añadir color (y a lo mejor hacer en un JTable)
        addButtons(_articulo, articulo);
        panelMap.put(articulo, _articulo);
        panelCesta.add(_articulo);
        panelCesta.revalidate();
        panelCesta.repaint();
    }

    @Override
    public void onArticuloRemoved(TOArticuloEnCesta articulo) {
        JPanel eliminar = panelMap.get(articulo);
        panelCesta.remove(eliminar);
        panelMap.remove(articulo);
        if (panelMap.isEmpty()) {
            panelCesta.add(mensajeCesta);
        }
        panelCesta.revalidate();
        panelCesta.repaint();
    }

    private void addButtons(JPanel panel, TOArticuloEnCesta art) {
        int stock = facade.getStock(art.getIdArticulo(), art.getColor().name(), art.getTalla().name());
        SpinnerNumberModel cantidad = new SpinnerNumberModel(art.getCantidad(), 0, stock, 1);
        JSpinner unidades = new JSpinner(cantidad);
        unidades.setMaximumSize(new Dimension(50, 20));
        panel.add(unidades);
        JButton anyadir = new JButton("Confirmar");
        panel.add(anyadir);
        anyadir.addActionListener((e -> {
            int uds = (int) unidades.getValue(); //TODO Comprobar stock?
            if (uds == 0) {
                facade.removeArticuloDeCesta(art);
            } else {
                art.setCantidad(uds);
                facade.actualizarArticuloEnCesta(art);
            }
        }));
    }


    @Override
    public void update() {
        facade.updateCesta();
    }

    @Override
    public void reset() {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, "Panel_cesta");
    }

    @Override
    public void onArticuloAdded(TOArticuloEnFavoritos toArticuloEnFavoritos) {
        panelFavs.remove(mensajeFavs);
        JPanel _articulo = new JPanel();
        _articulo.setLayout(new BoxLayout(_articulo, BoxLayout.X_AXIS));
        _articulo.add(new JLabel(facade.buscarArticulo(toArticuloEnFavoritos.getIdArticulo()).getNombre()));
        favsMap.put(toArticuloEnFavoritos, _articulo);
        panelFavs.add(_articulo);

        JButton anyadirACesta = new JButton("Añadir a cesta");
        anyadirACesta.setAlignmentX(Component.CENTER_ALIGNMENT);
        _articulo.add(anyadirACesta);
        anyadirACesta.addActionListener(e -> {
            mainWindow.goToArticulo(toArticuloEnFavoritos.getIdArticulo());
        });

        JButton delete = new JButton("Eliminar");
        delete.setAlignmentX(Component.RIGHT_ALIGNMENT);
        _articulo.add(delete);
        delete.addActionListener((e -> {
            favsMap.remove(toArticuloEnFavoritos);
            panelFavs.remove(_articulo);
        }));

        panelFavs.revalidate();
        panelFavs.repaint();
    }

    @Override
    public void onArticuloRemoved(TOArticuloEnFavoritos toArticuloEnFavoritos) {
        JPanel eliminar = favsMap.get(toArticuloEnFavoritos);
        favsMap.remove(toArticuloEnFavoritos);
        if (favsMap.isEmpty()) {
            panelFavs.add(mensajeFavs);
        }
        panelFavs.remove(eliminar);
        panelFavs.revalidate();
        panelFavs.repaint();
    }

    @Override
    public void onFavoritosChanged(Set<TOArticuloEnFavoritos> favoritos) {
        if (favoritos != null) {
            panelFavs.removeAll();//elimino lo antiguo
            favsMap.clear();
            Set<TOArticuloEnFavoritos> lista = favoritos;
            if (lista.isEmpty()) {
                panelFavs.add(mensajeFavs);
            } else {
                Iterator<TOArticuloEnFavoritos> art_it = lista.iterator();
                while (art_it.hasNext()) {
                    TOArticuloEnFavoritos art = art_it.next();
                    JPanel articulo = new JPanel();
                    articulo.setLayout(new BoxLayout(articulo, BoxLayout.X_AXIS));
                    articulo.add(new JLabel(facade.buscarArticulo(art.getIdArticulo()).getNombre()));
                    favsMap.put(art, articulo);
                    panelFavs.add(articulo);

                    JButton anyadirACesta = new JButton("Añadir a cesta");
                    anyadirACesta.setAlignmentX(Component.CENTER_ALIGNMENT);
                    articulo.add(anyadirACesta);
                    anyadirACesta.addActionListener(e -> {
                        mainWindow.goToArticulo(art.getIdArticulo());
                    });

                    JButton delete = new JButton("Eliminar");
                    delete.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    articulo.add(delete);
                    delete.addActionListener((e -> {
                        facade.removeArticuloDeFavoritos(art);
                        favsMap.remove(art);
                        panelFavs.remove(articulo);
                    }));
                }
            }
            panelFavs.revalidate();
            panelFavs.repaint();
        }
    }

    @Override
    public void onArticuloAdded(TOArticuloEnReservas toArticuloEnReservas) {
        JPanel _articulo = new JPanel();
        _articulo.setLayout(new BoxLayout(_articulo, BoxLayout.X_AXIS));
        _articulo.add(new JLabel(toArticuloEnReservas.getIdArticulo() + ""));
        reserMap.put(toArticuloEnReservas, _articulo);
        panelReservas.add(_articulo);
        JButton delete = new JButton("Eliminar reserva");
        delete.setAlignmentX(Component.RIGHT_ALIGNMENT);
        _articulo.add(delete);
        delete.addActionListener(e -> {
            facade.removeArticuloDeReservas(toArticuloEnReservas);
            reserMap.remove(toArticuloEnReservas);
            panelReservas.remove(_articulo);
        });
        panelReservas.revalidate();
        panelReservas.repaint();
    }

    @Override
    public void onArticuloRemoved(TOArticuloEnReservas toArticuloEnReservas) {
        JPanel eliminar = reserMap.get(toArticuloEnReservas);
        reserMap.remove(toArticuloEnReservas);
        panelReservas.remove(eliminar);
        panelReservas.revalidate();
        panelReservas.repaint();
    }

    @Override
    public void onReservasChanged(Set<TOArticuloEnReservas> reservas) {
        if (reservas != null) {
            panelReservas.removeAll();//elimino lo antiguo
            reserMap.clear();
            Set<TOArticuloEnReservas> lista = reservas;
            if (lista.isEmpty()) {
                panelReservas.add(mensajesReservas);
            } else {
                Iterator<TOArticuloEnReservas> art_it = lista.iterator();
                while (art_it.hasNext()) {
                    TOArticuloEnReservas art = art_it.next();
                    JPanel articulo = new JPanel();
                    articulo.setLayout(new BoxLayout(articulo, BoxLayout.X_AXIS));
                    articulo.add(new JLabel(art.getIdArticulo() + ""));
                    reserMap.put(art, articulo);
                    panelReservas.add(articulo);
                    JButton delete = new JButton("Eliminar reserva");
                    delete.setAlignmentX(Component.RIGHT_ALIGNMENT);
                    articulo.add(delete);
                    delete.addActionListener((e -> {
                        facade.removeArticuloDeReservas(art);
                        reserMap.remove(art);
                        panelReservas.remove(articulo);
                    }));
                }
            }
            panelReservas.revalidate();
            panelReservas.repaint();
        }
    }

    @Override
    public void onAuthChanged(boolean isAuth, int idUsuario) {
        if (buttonPanel != null) mainPanel.remove(buttonPanel);
        //PANEL DE LOS BOTONES
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        //CREAMOS BOTONES
        //BOTON CESTA
        JButton cesta = new JButton("Cesta");
        cesta.setAlignmentX(Component.CENTER_ALIGNMENT);
        cesta.addActionListener((e -> {
            cl.show(cards, "Panel_cesta");
            revalidate();
            repaint();
        }));
        buttonPanel.add(cesta);
        if (isAuth) {

            //BOTON FAVORITOS
            JButton favs = new JButton("Favoritos");
            favs.setAlignmentX(Component.CENTER_ALIGNMENT);
            favs.addActionListener((e -> {
                cl.show(cards, "Panel_favoritos");
                revalidate();
                repaint();
            }));
            buttonPanel.add(favs);

            //BOTON RESERVAS
            if (facade.getUsuario().getSuscripcion().equals(Suscripciones.PREMIUM)) {
                JButton reserva = new JButton("Reservas");
                reserva.setAlignmentX(Component.CENTER_ALIGNMENT);
                reserva.addActionListener((e -> {
                    cl.show(cards, "Panel_reservas");
                    revalidate();
                    repaint();
                }));
                buttonPanel.add(reserva);
            }
        }
        mainPanel.add(buttonPanel, BorderLayout.PAGE_START);
        revalidate();
        repaint();
    }

    public void showCesta() {
        cl.show(cards, "Panel_cesta");
        revalidate();
        repaint();
    }
}
