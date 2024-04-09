package model.usuarios;

import controller.Controller;
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
    protected String suscripcion;
    protected List<ArticuloAbstracto> favoritos;
    protected int id;
    protected String direccion;
    protected int saldo;

    public TUsuario (int Id) {
        this.id= Id;
    }

    protected TUsuario(int ID, String Nombre, String Apellidos, String Correo, String Contrasenya, String fechaNac, char Sexo, String Pais, String Suscripcion, String Direccion, int Saldo) {
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo_e() {
        return correo_e;
    }

    public void setCorreo_e(String correo_e) {
        this.correo_e = correo_e;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(String suscripcion) {
        this.suscripcion = suscripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + ", email=" + correo_e + "]";
    }

}
