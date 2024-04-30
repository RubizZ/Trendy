package negocio;

public class TOACestaUsuario {
    private TOCesta toCesta;
    private TOUsuario toUsuario;

    public TOACestaUsuario(TOCesta toCesta, TOUsuario toUsuario){
        this.toCesta = toCesta;
        this.toUsuario = toUsuario;
    }

    public TOCesta getToCesta() {
        return toCesta;
    }

    public TOUsuario getToUsuario() {
        return toUsuario;
    }
}