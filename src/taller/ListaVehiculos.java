package taller;

import vehiculosAbstractos.Vehiculo;
import java.util.Arrays;
import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public class ListaVehiculos {
    protected Vehiculo[] vehiculos;

    public ListaVehiculos() {
        vehiculos = new Vehiculo[0];
    }

    public void mete(Vehiculo vehiculo) {
        vehiculos = Arrays.copyOf(vehiculos, vehiculos.length + 1);
        vehiculos[vehiculos.length - 1] = vehiculo;
    }

    public boolean vacia() {
        return this.vehiculos.length == 0;
    }

    public void mostrarTotalIngresos() {
        double total = 0;

        if (this.vacia()) {
            for (Vehiculo vehiculo : vehiculos) {
                total += vehiculo.calcularPrecio();
            }
        }
        new GestorIO().out("El importe total es de " + total + " €");
    }
}
