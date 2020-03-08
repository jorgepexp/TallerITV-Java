package opciones;

import taller.Taller;

/**
 *
 * @author Jorge P.
 */
public class MostrarEstadoBox extends Opcion {
    
    private Taller taller;

    public MostrarEstadoBox(Taller taller) {
        super("Información del estado de un box concreto");
        this.taller = taller;
    }

    @Override
    public void ejecutar() {
        taller.getBox().mostrar();
    }
}
