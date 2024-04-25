package presentacion;

import negocio.Articulo;

import javax.swing.*;
import java.awt.*;

public class GUIArticulo extends JPanel {
    //Al haberle dado a un artículo de una categoría

    private Articulo art;
    private JButton atras;
    private String categoria;

    private JPanel t;
    private JMenu tallas;
    private DefaultComboBoxModel<String> colores;

    GUIArticulo(Articulo art, String cat){
        this.art = art;
        this.categoria = cat;
        initGUI();
    }

    private void initGUI(){
        this.setLayout(new BorderLayout());

        JPanel arriba = new JPanel();
        arriba.setLayout(new BoxLayout( arriba, BoxLayout.X_AXIS) );

        //BOTON ATRAS
        atras = new JButton("Atras");
        atras.setToolTipText("Vuelve a los articulos de la categoria seleccionada previamente");
        atras.addActionListener((e)-> {
            //llamar a la gui de los artículos en la categoría supongo
        });

        arriba.add(atras);

        add(Box.createRigidArea(new Dimension(30, 0)));

        //NOMBRE Y PRECIO:
        JLabel nombre = new JLabel(this.art.getName());
        arriba.add(nombre);
        add(Box.createRigidArea(new Dimension(10, 0)));

        JLabel precio = new JLabel(String.valueOf(this.art.getPrecio()));
        arriba.add(precio);
        add(Box.createRigidArea(new Dimension(30, 0)));


        //CATEGORIA Y SUBCATEGORIA
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout( info, BoxLayout.Y_AXIS));
        JLabel cat = new JLabel("Categoria: " + this.categoria);
        info.add(cat);
        JLabel subcat = new JLabel("Subcategoria: " + art.getSubcat().toString());
        info.add(subcat);
        arriba.add(info);

        this.add(arriba, BorderLayout.PAGE_START);



        //EL CENTRO, LA INFO DEL ARTICULO
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout( centro, BoxLayout.Y_AXIS));
        centro.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        this.t = new JPanel();
        t.setLayout(new BoxLayout( t, BoxLayout.X_AXIS));

        JLabel talla = new JLabel("Tallas:");
        //Botones de las tallas -> mejor hacemos el tipico menu
        this.tallas = new JMenu("Selecciona talla");
        JCheckBoxMenuItem XS = new JCheckBoxMenuItem("XS");
        JCheckBoxMenuItem S = new JCheckBoxMenuItem("S");
        JCheckBoxMenuItem M = new JCheckBoxMenuItem("M");
        JCheckBoxMenuItem L = new JCheckBoxMenuItem("L");
        JCheckBoxMenuItem XL = new JCheckBoxMenuItem("XL");
        tallas.add(XS);
        tallas.add(S);
        tallas.add(M);
        tallas.add(L);
        tallas.add(XL);
       // if(S.isSelected())

        t.add(talla);
        t.add(tallas);
        centro.add(t);

        //Colores:
        JPanel color = new JPanel();
        color.setLayout(new BoxLayout( this, BoxLayout.X_AXIS));
        JLabel c = new JLabel("Color");
        colores = new DefaultComboBoxModel<>();

    }

}
