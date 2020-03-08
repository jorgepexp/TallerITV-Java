package opciones;

import taller.ColaVehiculos;
import taller.Taller;
import util.GestorIO;
import vehiculosAbstractos.Vehiculo;

/**
 * @author Jorge P.
 */
public class PagarEIrse extends Opcion {

    private Taller taller;

    public PagarEIrse(Taller taller) {
        super("Calcular y pagar vehículo revisado");
        this.taller = taller;
    }

    @Override
    public void ejecutar() {
        GestorIO gestor = new GestorIO();
        ColaVehiculos colaPendientesPago = taller.getColaPendientesPago();

        if (colaPendientesPago.vacia()) {
            gestor.out("Error!!! No hay vehículos en la cola\n");
        } else {
            colaPendientesPago.mostrar();
            Vehiculo vehiculo = taller.getColaPendientesPago().saca();
            double importe = vehiculo.calcularPrecio();

            gestor.out("Total a pagar " + importe + " €\n");
            taller.getListaPagados().mete(vehiculo);
        }
    }
}