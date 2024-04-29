package negocio;

import java.util.Collection;

public class BussinesDelegate {
    private BOUsuario boUsuario = new BOUsuario();
    public void create(TUsuario tUsuario) {
        boUsuario.create(tUsuario);
    }

    public TUsuario read() {
        return boUsuario.read();
    }

    public Collection<TUsuario> readAll() {
        return boUsuario.readAll();
    }

    public void update(TUsuario tUsuario) {boUsuario.update(tUsuario);
    }

    public void delete(int id) {boUsuario.delete(id);
    }

    public void actualizarSaldo(int cantidad){boUsuario.actualizarCesta(cantidad);}

    public void actualizarSusc(int id) {
        boUsuario.actualizarSuscr(id);
    }
}
