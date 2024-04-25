package presentacion;

import negocio.Articulo;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GUICategoria extends JPanel {
    //Después de haberle dado a una categoría en si

    Map<JButton, String> articulos;
    //Boton ccon el nombre del artículo, precio del artículo
    private SAFacade sa;
    private String cat;
    private JButton atras;

    GUICategoria(SAFacade sa, String cat){
        this.sa = sa;
        this.cat = cat;
        initGUI();
    }

    private void initGUI(){
        this.setLayout(new BorderLayout());

        //PANEL QUE TENDRÁ LA LISTA DE ARTICULOS DE LA CATEGORÍA
        JPanel art = new JPanel();
        art.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS) );
        art.setAlignmentX(JComponent.LEFT_ALIGNMENT);

        List<Articulo> lista = this.sa.buscaArticulosCategoria(this.cat);
        for(Articulo a : lista){
            JButton botonart = new JButton(a.getName());
            botonart.setToolTipText("Muestra este articulo");
            botonart.addActionListener((e)-> {
                //mandar a interfaz de un artículo
            });
            articulos.put(botonart, String.valueOf(a.getPrecio()) + "€");
        }

        for(JButton b : this.articulos.keySet()){
            art.add(b);
        }
        this.add(art, BorderLayout.CENTER);

        //Ahora hay que crear lo de arriba (el boton de atrás y el de filtrar)
        //BOTÓN ATRÁS
        this.atras = new JButton("Atras");
        atras.setToolTipText("Vuelve a las categorías");
        atras.addActionListener((e)-> {
            //llamar a la gui de categorias supongo
        });

    }


}
