package negocio;

import model.articulo.ArticuloAbstracto;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class TUsuario implements Serializable {
    protected String nombre;
    protected String apellidos;
    protected String correo_e;
    protected String contrasenya;
    protected String fechaNacimiento;//TODO cambiar a tipo fecha
    protected char sexo;
    protected String pais;
    protected int suscripcion;
    protected List<ArticuloAbstracto> favoritos;
    protected int id;
    protected String direccion;
    protected int saldo;

    public TUsuario (int Id) {
        this.id= Id;
    }

    protected TUsuario(int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, int Suscripcion, String Direccion, int Saldo) {
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

    public TUsuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public TUsuario setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public TUsuario setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
        return this;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public TUsuario setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
        return this;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public TUsuario setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
        return this;
    }

    public char getSexo() {
        return sexo;
    }

    public TUsuario setSexo(char sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public TUsuario setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public int getSuscripcion() {
        return suscripcion;
    }

    public TUsuario setSuscripcion(int suscripcion) {
        this.suscripcion = suscripcion;
        return this;
    }

    public List<ArticuloAbstracto> getFavoritos() {
        return favoritos;
    }

    public TUsuario setFavoritos(List<ArticuloAbstracto> favoritos) {
        this.favoritos = favoritos;
        return this;
    }

    public int getId() {
        return id;
    }

    public TUsuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public TUsuario setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public int getSaldo() {
        return saldo;
    }

    public TUsuario setSaldo(int saldo) {
        this.saldo = saldo;
        return this;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", email=" + correo_e + "]";
    }

}
