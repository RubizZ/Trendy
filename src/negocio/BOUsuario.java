package negocio;

import model.articulo.ArticuloAbstracto;
import model.usuarios.PersonaAbstracta;
import presentacion.Controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOUsuario extends PersonaAbstracta {
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

    protected BOUsuario(Controller contr, int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
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


    public String getNombre() {
        return nombre;
    }

    public BOUsuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public BOUsuario setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public BOUsuario setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
        return this;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public BOUsuario setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
        return this;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public BOUsuario setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public char getSexo() {
        return sexo;
    }

    public BOUsuario setSexo(char sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public BOUsuario setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public BOUsuario setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public BOUsuario setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getSaldo() {
        return saldo;
    }

    public BOUsuario setSaldo(int saldo) {
        this.saldo = saldo;
        return this;
    }

    public int getId() {
        return id;
    }

    public BOUsuario setId(int id) {
        this.id = id;
        return this;
    }

    public List<ArticuloAbstracto> getFavoritos() {
        return favoritos;
    }

    public BOUsuario setFavoritos(List<ArticuloAbstracto> favoritos) {
        this.favoritos = favoritos;
        return this;
    }
}
