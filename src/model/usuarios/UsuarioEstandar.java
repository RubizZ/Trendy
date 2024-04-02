package model.usuarios;

import controller.Controller;
import model.usuarios.Usuario;

public class UsuarioEstandar extends Usuario {
    UsuarioEstandar(Controller contr, int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
        super(contr, ID, Nombre, Apellidos, Correo, Contrasenya, fechaNac, Sexo, Pais, "ESTANDAR", Direccion, Saldo);
    }
}
