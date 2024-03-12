package model;

import controller.Controller;
import model.articulo.ArticuloAbstracto;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UsuarioRegistrado extends PersonaAbstracta{

    protected String nombre;
    protected String apellidos;
    protected String correo_e;
    protected String contrasenya;
    protected String fechaNacimiento;//TODO cambiar a tipo fecha
    protected char sexo;
    protected String pais;
    protected String suscripcion;

    protected List<ArticuloAbstracto> favoritos;

    UsuarioRegistrado(Controller contr, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String suscrpcion) {
        super(contr);

        nombre = Nombre;
        apellidos = Apellidos;
        correo_e =Correo;
        contrasenya = Contrasenya;
        fechaNacimiento = fechaNac;
        sexo = Sexo;
        pais = Pais;
        favoritos = new LinkedList<>();
        suscripcion = suscrpcion;
    }

    protected void anyadirAFavoritos(ArticuloAbstracto a){
        favoritos.add(a);
    }

    protected void eliminarDeFavoritos(ArticuloAbstracto a){
        favoritos.remove(a);
    }

    protected List<ArticuloAbstracto> pedirFavoritos(){
        return Collections.unmodifiableList(favoritos);
    }

    protected void cambiarCorreo(String Correo){

    }

    protected void cambiarContrasenya(String Contrasenya){

    }
    protected void cambiarNombre(String Nombre){

    }
    protected void cambiarApellido(String Apellidos){

    }
    protected void cambiarFechaNac(String Fecha){

    }
    protected void cambiarSexo(char Sexo){

    }

    protected void cambiarPais(String Pais){

    }

    protected void cambiarSuscrpcion(){
        controlador.cambiarSuscripcion();
    }
}
