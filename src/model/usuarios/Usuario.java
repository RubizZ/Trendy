package model.usuarios;

import negocio.PersonaAbstracta;
import presentacion.Controller;
import model.articulo.ArticuloAbstracto;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Usuario extends PersonaAbstracta {

    protected String nombre;
    protected String apellidos;
    protected String correo_e;
    protected String contrasenya;
    protected String fechaNacimiento;//TODO cambiar a tipo fecha
    protected char sexo;
    protected String pais;
    protected String suscripcion;
    protected String direccion;
    protected int saldo;
    protected int id;

    protected List<ArticuloAbstracto> favoritos;//tiene que tener un id a una lista de favoritos

    protected Usuario(Controller contr, int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
        super(contr);
        id = ID;
        nombre = Nombre;
        apellidos = Apellidos;
        correo_e =Correo;
        contrasenya = Contrasenya;
        fechaNacimiento = fechaNac;
        sexo = Sexo;
        pais = Pais;
        favoritos = new LinkedList<>();
        suscripcion = Suscripcion;
        direccion = Direccion;
        saldo = Saldo;
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
