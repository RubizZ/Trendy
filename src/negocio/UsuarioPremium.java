package negocio;

import model.usuarios.Usuario;
import presentacion.Controller;

public class UsuarioPremium extends BOUsuario {

    UsuarioPremium(Controller contr, int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
        super(contr, ID, Nombre, Apellidos, Correo, Contrasenya, fechaNac, Sexo, Pais, "PREMIUM", Direccion, Saldo);
    }
}
