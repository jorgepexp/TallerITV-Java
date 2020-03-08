package opciones;

import taller.Box;
import util.GestorIO;
import taller.Taller;

/**
 *
 * @author Jorge P.
 */
public class ReclamarVehiculo extends Opcion {

    private Taller taller;

    public ReclamarVehiculo(Taller taller) {
        super("Reclamar vehículo para entrar en box");
        this.taller = taller;
    }

    @Override
    public void ejecutar() {
        GestorIO gestor = new GestorIO();

        if (!taller.getColaVehiculos().vacia()) {
            Box box = taller.getBox();
            if (box.estaLibre()) {
                box.mete(taller.getColaVehiculos().saca());
                gestor.out("Vehículo añadido al box " + box + "\n");
            } else
                gestor.out("Error!!! Box ocupado en la primera fase. Utilice opción 3 para continuar\n");
        } else
            gestor.out("Error!!! No hay vehículos en la cola\n");
    }
}
