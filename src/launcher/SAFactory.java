package launcher;

import negocio.AbstractSA;
import negocio.BusinessDelegate;

public interface SAFactory {

    //TODO Hacer la fabrica de SA

    AbstractSA getTestSA(BusinessDelegate businessDelegate);

    //añadir get<nombre>SA() para cada SA
}
