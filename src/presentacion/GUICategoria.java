package presentacion;

import negocio.Articulo;
import negocio.BOStock;
import negocio.SAFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GUICategoria extends MainGUIPanel implements ActionListener {
    //Después de haberle dado a una categoría en si

    Map<JButton, Articulo> articulos;
    private JPanel pcat;
    private SAFacade sa;
    private String cat;
    private JButton atras;
    private GUIPpalCategorias guippal;
    private JPanel art;

    GUICategoria(SAFacade sa, String cat, GUIPpalCategorias ppal) {
        this.sa = sa;
        this.cat = cat;
        this.guippal = ppal;
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
            mcolor.add(colores);
        }
        filtro.add(mcolor);

        JPanel precio = new JPanel();
        precio.setLayout(new BoxLayout(precio, BoxLayout.X_AXIS));
        JLabel lprecio = new JLabel("Precio máx.");
        DefaultComboBoxModel<String> precios = new DefaultComboBoxModel<>();
        precios.addElement("-");
        precios.addElement("10 €");
        precios.addElement("25 €");
        precios.addElement("50 €");
        JComboBox boxprecios = new JComboBox(precios);
        precio.add(lprecio);
        precio.add(boxprecios);
        filtro.add(precio);

        JMenu msubcat = new JMenu("Subcategoria");
        for (Articulo.Subcategoria a : Articulo.Subcategoria.values()) {
            JCheckBoxMenuItem subcat = new JCheckBoxMenuItem(Articulo.subcategoriaToString(a));
            msubcat.add(subcat);
        }
        filtro.add(msubcat);

        JPanel talla = new JPanel();
        talla.setLayout(new BoxLayout(talla, BoxLayout.X_AXIS));
        JLabel ltalla = new JLabel("Talla");
        DefaultComboBoxModel<String> tallas = new DefaultComboBoxModel<>();
        tallas.addElement("XS");
        tallas.addElement("S");
        tallas.addElement("M");
        tallas.addElement("L");
        tallas.addElement("XL");
        JComboBox boxtallas = new JComboBox(tallas);
        talla.add(ltalla);
        talla.add(boxtallas);
        filtro.add(talla);

        fmenuBar.add(filtro);
        arriba.add(fmenuBar);
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
        List<Articulo> lista = this.sa.buscaArticulosCategoria(this.cat);
        for (Articulo a : lista) {
            JButton botonart = new JButton(a.getName());
            botonart.setToolTipText("Muestra este articulo");
            botonart.addActionListener(this);
            articulos.put(botonart, a);
        }
        for (JButton b : this.articulos.keySet()) {
            art.add(b);
        }
        pcat.add(art, BorderLayout.CENTER);
    }

    @Override
    public void update() {
        for (JButton b : articulos.keySet()) {
            art.remove(b);
        }
        articulos.clear();
        añadeBotones();
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
}
