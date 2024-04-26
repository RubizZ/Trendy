package negocio;

import java.util.Collection;

public class BussinesDelegate {
    private BOUsuario boUsuario = new BOUsuario();
    public void create(TUsuario tUsuario) {
        boUsuario.create(tUsuario);
    }

    public TUsuario read(TUsuario usuario) {
        return boUsuario.read(usuario);
    }

    public Collection<TUsuario> readAll() {
        return boUsuario.readAll();
    }

    public void update(TUsuario tUsuario) {boUsuario.update(tUsuario);
    }

    public void delete(int id) {boUsuario.delete(id);
    }
}
