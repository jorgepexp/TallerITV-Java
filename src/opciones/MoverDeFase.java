package opciones;

import taller.Taller;
import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public class MoverDeFase extends Opcion {

    private Taller taller;

    public MoverDeFase(Taller taller) {
        super("Mover todos los vehículos de fase dentro de un box");
        this.taller = taller;
    }

    @Override
    public void ejecutar() {
        GestorIO gestorIO = new GestorIO();
        
        taller.getBox().pasaVehiculosDeFase();
        gestorIO.out("Vehículos desplazados de fase correctamente.\n");
    }
}
