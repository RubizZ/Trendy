package model;

import controller.Controller;
import model.articulo.ArticuloAbstracto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class PersonaAbstracta implements Persona{

    protected List<ArticuloAbstracto> Cesta;
    protected Controller controlador;
    PersonaAbstracta(Controller contr){
        Cesta = new LinkedList<>();
        controlador = contr;
    }
    @Override
    public void anyadirACesta(ArticuloAbstracto a) {
        Cesta.add(a);
    }

    @Override
    public void eliminarDeCesta(ArticuloAbstracto a) {
        Cesta.remove(a);
    }

    @Override
    public List<ArticuloAbstracto> pedirCesta() {
        return Collections.unmodifiableList(Cesta);
    }

    @Override
    public void logIn() {
        String Usuario;
        String Contrasenya;
        //controlador.logIn(Usuario, Contrasenya);
    }
}
