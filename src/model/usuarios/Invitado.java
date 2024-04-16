package model.usuarios;

import presentacion.Controller;

public class Invitado extends PersonaAbstracta {

    Invitado(Controller contr) {
        super(contr);
    }


    void registro(){
        String nombre;
        String apellidos;
        String correo_e;
        String contrasenya;
        String fecha_nacimiento;//TODO cambiar a tipo fecha
        char sexo;
        String pais;
        controlador.registro(nombre, apellidos, correo_e, contrasenya, fecha_nacimiento, sexo, pais);
    }
}
