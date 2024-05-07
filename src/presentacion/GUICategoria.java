package presentacion;

import negocio.Articulo;
import negocio.BOStock;
import negocio.SAFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

public class GUICategoria extends MainGUIPanel implements ActionListener {
    //Después de haberle dado a una categoría en si

    Map<JButton, Articulo> articulos;
    private JPanel pcat;
    private SAFacade sa;
    private String cat;
    private JButton atras;
    private GUIPpalCategorias guippal;
    private JPanel art;
    private String subcatfiltro;
    private String colorfiltro;
    private String preciofiltro;
    private String tallafiltro;
    private static String[] valoresprecio = {"10 €", "25 €", "50 €"};

    GUICategoria(SAFacade sa, String cat, GUIPpalCategorias ppal) {
        this.sa = sa;
        this.cat = cat;
        this.guippal = ppal;
        subcatfiltro = "";
        colorfiltro = "";
        preciofiltro = "";
        tallafiltro = "";
        initGUI();
    }

    private void initGUI() {

        pcat = new JPanel();
        pcat.setLayout(new BorderLayout());

        //PANEL QUE TENDRÁ LA LISTA DE ARTICULOS DE LA CATEGORÍA
        art = new JPanel();
        art.setLayout(new BoxLayout(art, BoxLayout.Y_AXIS));
        art.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        this.articulos = new HashMap<>();
        añadeBotones();

        //Parte de arriba de la interfaz
        JPanel arriba = new JPanel();
        //BOTÓN ATRÁS
        this.atras = new JButton("Atras");
        atras.setToolTipText("Vuelve a las categorías");
        atras.addActionListener((e) -> {
            this.guippal.setViewportView(this.guippal.getPanelView());
        });
        atras.setAlignmentX(LEFT_ALIGNMENT);
        arriba.add(atras);

        //BOTON FILTRAR
        JMenuBar fmenuBar = new JMenuBar();
        JMenu filtro = new JMenu("Filtrar");
        filtro.setToolTipText("Filtra los productos con determinadas caracteristicas");
        filtro.setAlignmentX(RIGHT_ALIGNMENT);

        JMenu mcolor = new JMenu("Color");
        for (BOStock.Color a : BOStock.Color.values()) {
            JCheckBoxMenuItem colores = new JCheckBoxMenuItem(BOStock.colorToString(a));
            colores.addActionListener((e) -> {
                if (colores.isSelected()) colorfiltro = colores.getText();
                else colorfiltro = "";
            });
            mcolor.add(colores);
        }
        filtro.add(mcolor);

        JMenu mprecio = new JMenu("Precio max.");
        for (String a : valoresprecio) {
            JCheckBoxMenuItem vprecios = new JCheckBoxMenuItem(a);
            vprecios.addActionListener((e) -> {
                if (vprecios.isSelected()) {
                    StringTokenizer tokens = new StringTokenizer(vprecios.getText());
                    preciofiltro = tokens.nextToken();
                } else preciofiltro = "";

            });
            mprecio.add(vprecios);
        }
        filtro.add(mprecio);

        JMenu msubcat = new JMenu("Subcategoria");
        for (Articulo.Subcategoria a : Articulo.Subcategoria.values()) {
            JCheckBoxMenuItem subcat = new JCheckBoxMenuItem(Articulo.subcategoriaToString(a));

            subcat.addActionListener((e) -> {
                if (subcat.isSelected()) subcatfiltro = subcat.getText();
                else subcatfiltro = "";

            });

            msubcat.add(subcat);
        }
        filtro.add(msubcat);

        JMenu mtalla = new JMenu("Talla");
        for (BOStock.Talla a : BOStock.Talla.values()) {
            JCheckBoxMenuItem talla = new JCheckBoxMenuItem(BOStock.tallatoString(a));
            talla.addActionListener((e) -> {
                if (talla.isSelected()) tallafiltro = talla.getText();
                else tallafiltro = "";

            });
            mtalla.add(talla);
        }
        filtro.add(mtalla);

        fmenuBar.add(filtro);
        arriba.add(fmenuBar);

        //BOTON BUSCAR (aplica los filtros seleccionados)
        JButton buscar = new JButton("Buscar");
        buscar.setToolTipText("Aplica los filtros seleccionados");
        buscar.addActionListener((e) -> {
            update();
        });
        arriba.add(buscar);

        pcat.add(arriba, BorderLayout.PAGE_START);

        this.setVisible(true);
        this.setViewportView(pcat);
    }

    public void actionPerformed(ActionEvent e) {
        Articulo a = this.articulos.get(e.getSource());
        if (a != null) {
            this.setVisible(false);
            GUIArticulo art = new GUIArticulo(a, cat, this, this.sa);
            this.guippal.setViewportView(art);
        }
    }

    private void añadeBotones() {
        try {
            List<Articulo> lista = this.sa.buscaArticulosCategoria(this.cat);

            List<Articulo> filtro = new ArrayList<>();
            boolean hayfiltro = false;

            if (!preciofiltro.equals("")) {
                hayfiltro = true;
                double p = Double.parseDouble(preciofiltro);
                List<Articulo> listap = this.sa.buscaFiltro(lista, Articulo -> Articulo.getPrecio() <= p);
                filtro.addAll(listap);
            }
            if (!subcatfiltro.equals("")) {
                List<Articulo> listasub = this.sa.buscaFiltro(lista, Articulo -> Articulo.subcategoriaToString(Articulo.getSubcat()).equals(subcatfiltro));

                if (!hayfiltro) filtro.addAll(listasub);
                else {
                    Iterator<Articulo> it = filtro.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (!listasub.contains(it)) {
                            it.remove();
                        }
                    }
                }

                hayfiltro = true;
            }

            if (!colorfiltro.equals("")) {
                List<Articulo> listac = this.sa.buscaFiltro(lista, Articulo -> sa.getStockColor(Articulo.getID(), colorfiltro) > 0);

                if (!hayfiltro) filtro.addAll(listac);
                else {
                    Iterator<Articulo> it = filtro.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (!listac.contains(it)) {
                            it.remove();
                        }
                    }
                }

                hayfiltro = true;
            }
            if (!tallafiltro.equals("")) {
                List<Articulo> listat = this.sa.buscaFiltro(lista, Articulo -> sa.getStockTalla(Articulo.getID(), tallafiltro) > 0);

                if (!hayfiltro) filtro.addAll(listat);
                else {
                    Iterator<Articulo> it = filtro.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (!listat.contains(it)) {
                            it.remove();
                        }
                    }
                }

                hayfiltro = true;
            }

            if (!hayfiltro) filtro = lista;

            for (Articulo a : filtro) {
                JButton botonart = new JButton(a.getName());
                botonart.setToolTipText("Muestra este articulo");
                botonart.addActionListener(this);
                articulos.put(botonart, a);
            }
            for (JButton b : this.articulos.keySet()) {
                art.add(b);
            }
        } catch (Exception e) {
            JLabel mensaje = new JLabel(e.getMessage());
            art.add(mensaje);
        }
        pcat.add(art, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        art.removeAll();
        articulos.clear();
        boolean selected = false;

        añadeBotones();

        this.guippal.setViewportView(pcat);
    }

    @Override
    public void reset() {
        this.guippal.setViewportView(this.guippal.getPanelView());
        this.setVisible(false);
    }

    public JPanel getPanelView() {
        return this.pcat;
    }

    public void setJPanelViewCat() {
        this.guippal.setJPanelViewCat(this.pcat);
    }

    public void goToArticulo(Articulo articulo) {
        this.setVisible(false);
        GUIArticulo art = new GUIArticulo(articulo, cat, this, this.sa);
        this.guippal.setViewportView(art);
        revalidate();
        repaint();
    }
}
