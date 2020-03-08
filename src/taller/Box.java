package taller;

import vehiculosAbstractos.Vehiculo;
import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public class Box {

    private int id;
    private FaseRevision[] fasesRevision;
    private ColaVehiculos colaPendientesPago;

    private static final String[] TITULOS_FASES = new String[]{
        "1(Seguridad)",
        "2(Sistema eléctrico)",
        "3(Humos)",
        "4(Frenos y dirección)"
    };
    private static final int NUM_FASES = 4;

    public Box(int id, ColaVehiculos colaPendientesPago) {
        this.id = id;
        this.fasesRevision = new FaseRevision[NUM_FASES];
        for (int i = 0; i < this.fasesRevision.length; i++) {
            this.fasesRevision[i] = new FaseRevision(TITULOS_FASES[i]);
        }
        
        this.colaPendientesPago = colaPendientesPago;
    }

    public boolean estaLibre() {
        return !this.fasesRevision[0].hayVehiculo();
    }

    private boolean esPrimeraFase(int indiceFase) {
        return indiceFase == 0;
    }

    public void mete(Vehiculo vehiculo) {
        fasesRevision[0].asigna(vehiculo);
    }

    public void pasaVehiculosDeFase() {
        int ultimaFase = fasesRevision.length - 1;
        if (fasesRevision[ultimaFase].hayVehiculo()) {
            fasesRevision[ultimaFase].asignaVehiculoA(colaPendientesPago);
        }
        
        for (int i = fasesRevision.length - 1; i > 0; i--) {
            if (!esPrimeraFase(i)) {
                this.fasesRevision[i - 1].asignaVehiculoA(this.fasesRevision[i]);
            }
        }
        this.fasesRevision[0].desasignaVehiculo();
    }

    public void mostrar() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("\nBox:" + id + "\n----");
        for (FaseRevision faseRevision : fasesRevision) {
            faseRevision.mostrar();
        }
    }
}
