package vehiculos;

import vehiculosAbstractos.VehiculoDeCarga;

/**
 *
 * @author Jorge P.
 */
public class Furgoneta extends VehiculoDeCarga {

    public Furgoneta(String matricula, String modelo, int cilindros, int potencia, double PMA) {
        super(matricula, modelo, cilindros, potencia, PMA);
    }

    @Override
    public double calcularPrecio() {
        return super.calcularPrecio();
    }
}
