package taller;

import vehiculosAbstractos.Vehiculo;
import java.util.Arrays;
import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public class ColaVehiculos extends ListaVehiculos {

    static Vehiculo vehiculo;

    public ColaVehiculos() {
        super();
    }

    public Vehiculo saca() {
        assert !vacia();

        Vehiculo vehiculo = vehiculos[0];

        for (int i = 1; i < vehiculos.length; i++) {
            this.vehiculos[i - 1] = this.vehiculos[i];
        }
        vehiculos = Arrays.copyOf(vehiculos, vehiculos.length - 1);
        return vehiculo;
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        if (!this.vacia()) {
            gestorIO.out("\nCola de vehículos: ");
            for (Vehiculo vehiculo : vehiculos) {
                gestorIO.out("\n" + vehiculo);
            }
        }
    }
}
