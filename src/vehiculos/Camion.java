package vehiculos;

import vehiculosAbstractos.VehiculoDeCarga;
/**
 *
 * @author Jorge P.
 */
public class Camion extends VehiculoDeCarga {
 
    private static final int PRECIO_FIJO = 40;
    private static final int PRECIOxPOTENCIA = 20;
    private static final int MAX_POTENCIA = 2000;
    private static final double PORCENTAJE_ADICIONAL = 0.2;
    
    public Camion(String matricula, String modelo, int cilindros, int potencia, double PMA) {
        super(matricula, modelo, cilindros, potencia, PMA);
    }

    @Override
    public double calcularPrecio() {
        double totalInicial = super.calcularPrecio();
        double total = super.calcularPrecio();
        
        total += PRECIO_FIJO;
        total += totalInicial * PORCENTAJE_ADICIONAL;
        if (potencia > MAX_POTENCIA) {
            total += PRECIOxPOTENCIA;
        }
        return total;
    }
}
