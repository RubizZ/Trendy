package presentacion;


import negocio.Articulo;
import negocio.SAFacade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

public class GUIPpalCategorias extends MainGUIPanel implements ActionListener {
    //Lo que es mostrar la lista de categorías

    private List<JButton> categorias;
    private List<String> lcat;
    private SAFacade sa;
    private JPanel pcategorias;

    GUIPpalCategorias(SAFacade sa) {
        super();
        this.sa = sa;
        this.categorias = new LinkedList<>();
        lcat = this.sa.getCategorias();
        initGUI();
    }

    private void initGUI() {

        pcategorias = new JPanel();
        pcategorias.setLayout(new BoxLayout(pcategorias, BoxLayout.Y_AXIS));
        pcategorias.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        añadeBotones();

        this.setViewportView(pcategorias);
    }

    public void actionPerformed(ActionEvent e) {
        int i = 0;
        while (i < this.categorias.size() && e.getSource() != this.categorias.get(i)) i++;
        if (i < this.categorias.size()) {
            GUICategoria guicat = new GUICategoria(sa, this.categorias.get(i).getText(), this);
            this.setViewportView(guicat);
        }
    }

    @Override
    public void update() {
        lcat = this.sa.getCategorias();
        for (JButton b : categorias) {
            pcategorias.remove(b);
        }
        this.categorias.clear();
        añadeBotones();
    }

    @Override
    public void reset() {
    }

    private void añadeBotones() {
        for (String s : this.lcat) {
            JButton cat = new JButton(s);
            cat.addActionListener(this);
            pcategorias.add(cat);
            categorias.add(cat);
        }
    }

    public JPanel getPanelView() {
        return this.pcategorias;
    }

    public void setJPanelViewCat(JPanel view) {
        this.setViewportView(view);
    }

    public void goToArticulo(int idArticulo) {
        for (String categoria : sa.getCategorias()) {
            for (Articulo articulo : sa.buscaArticulosCategoria(categoria)) {
                if (articulo.getID() == idArticulo) {
                    GUICategoria guicat = new GUICategoria(sa, categoria, this);
                    guicat.goToArticulo(articulo);
                    return;
                }
            }
        }
    }
}
