package presentacion;

import javax.swing.*;
import java.util.List;
import java.util.Set;

public class GUIPpalCategorias extends JPanel {
    //Lo que es mostrar la lista de categorías

    private Set<JButton> categorias;
    private List<String> lcat;
    private SAFacade sa;

    GUIPpalCategorias(int n, SAFacade sa){
        this.ncat = n;
        this.sa = sa;
        lcat = this.sa.getCategorias();
        initGUI();
    }

    private void initGUI(){
        this.setLayout(new BoxLayout( this, BoxLayout.Y_AXIS) );
        this.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        //Hay que hacer los botones de cada categoría

        for(int i = 0; i < this.lcat.size(); i++){
            JButton cat = new JButton(lcat.get(i));
            cat.addActionListener((e) -> {
                //abrir interfaz de una categoria
            });
            categorias.add(cat);
        }

        for(JButton b : categorias){
            this.add(b);
        }

    }
}
