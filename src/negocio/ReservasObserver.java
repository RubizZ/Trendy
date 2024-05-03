package negocio;

import java.util.Set;

public interface ReservasObserver {
    void onArticuloAdded(TOArticuloEnReservas toArticuloEnReservas);

    void onArticuloRemoved(TOArticuloEnReservas toArticuloEnReservas);

    void onReservasChanged(Set<TOArticuloEnReservas> reservas);
}
