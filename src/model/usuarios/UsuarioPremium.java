package model.usuarios;

import controller.Controller;
import model.usuarios.Usuario;

public class UsuarioPremium extends Usuario {

    UsuarioPremium(Controller contr, int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
        super(contr, ID, Nombre, Apellidos, Correo, Contrasenya, fechaNac, Sexo, Pais, "PREMIUM", Direccion, Saldo);
    }
}
