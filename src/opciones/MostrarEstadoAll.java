package opciones;

import taller.Taller;

/**
 *
 * @author Jorge P.
 */
public class MostrarEstadoAll extends Opcion {

    private Taller taller;
    
    public MostrarEstadoAll(Taller taller) {
        super("Información general de todos los boxes");
        this.taller = taller;
    }
    
    @Override
    public void ejecutar(){
        taller.mostrar();
    }
}
