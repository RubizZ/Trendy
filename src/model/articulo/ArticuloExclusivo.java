package model.articulo;

import java.time.LocalDate;

public class ArticuloExclusivo extends ArticuloAbstracto {

    private String fechaLanzamiento;
    private boolean lanzado;
    //Aqui iria la lista de reservas

    public ArticuloExclusivo(){


    }

    @Override
    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public boolean haSalido(){
        return fechaLanzamiento.equals(LocalDate.now().toString());
    }
}
