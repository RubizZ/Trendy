package model.usuarios;

import controller.Controller;
import model.articulo.ArticuloAbstracto;
import model.usuarios.Persona;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



public class PersonaAbstracta implements Persona {

    protected List<ArticuloAbstracto> Cesta;
    protected Controller controlador;
    public PersonaAbstracta(Controller contr){
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
