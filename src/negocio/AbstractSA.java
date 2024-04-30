package negocio;

public abstract class AbstractSA {

    //TODO Hacer que todo SA herede de AbstractSA

    protected final BusinessDelegate businessDelegate;

    public AbstractSA(BusinessDelegate businessDelegate) {
        this.businessDelegate = businessDelegate;
    }
}
