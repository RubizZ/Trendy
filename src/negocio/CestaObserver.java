package negocio;

public interface CestaObserver extends Observer {
    void onCestaChanged(TOCesta cesta);
}
