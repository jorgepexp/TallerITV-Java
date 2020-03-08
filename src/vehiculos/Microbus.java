package vehiculos;

import vehiculosAbstractos.Vehiculo;

/**
 *
 * @author Jorge P.
 */
public class Microbus extends Vehiculo {

    private int plazas;
    
    private static final double PRECIOxPLAZA = 2;

    public Microbus(String matricula, String modelo, int cilindros, int potencia, int plazas) {
        super(matricula, modelo, cilindros, potencia);
        this.plazas = plazas;
    }

    @Override
    public double calcularPrecio() {
        double total = super.calcularPrecio();
        total += this.plazas * PRECIOxPLAZA;

        return total;
    }
}
