package model;

import controller.Controller;

public class UsuarioPremium extends UsuarioRegistrado{

    UsuarioPremium(Controller contr, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String pais) {
        super(contr, Nombre, Apellidos, Correo, Contrasenya, fechaNac, Sexo, pais, "PREMIUM");
    }
}
