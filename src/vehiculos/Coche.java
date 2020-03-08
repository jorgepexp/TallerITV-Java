package vehiculos;

import vehiculosAbstractos.Vehiculo;

/**
 *
 * @author Jorge P.
 */
public class Coche extends Vehiculo {

    private int plazas;

    private static final double PRECIOxPLAZA = 1.5;
    private static final int PRECIOxPOTENCIA = 10;
    private static final int MAX_POTENCIA = 1200;

    public Coche(String matricula, String modelo, int cilindros, int potencia, int plazas) {
        super(matricula, modelo, cilindros, potencia);
        this.plazas = plazas;
    }

    @Override
    public double calcularPrecio() {
        double total = super.calcularPrecio();
        if (this.plazas > 3) {
            total += this.plazas * PRECIOxPLAZA;
            total -= PRECIOxPLAZA * 3; //Esto es porque solo se suma el precio por plaza cuando estas exceden de 3, así que simplemente le resto 3
        }
        if (potencia > MAX_POTENCIA) {
            total += PRECIOxPOTENCIA;
        }
        
        return total;
    }
}
