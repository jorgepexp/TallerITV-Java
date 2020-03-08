package vehiculosAbstractos;

/**
 *
 * @author Jorge P.
 */
public abstract class VehiculoDeCarga extends Vehiculo {
    
    private double PMA;
    
    private static final int PRECIO_FIJO = 3;
    private static final int PRECIO_FIJO_B = 4;

    public VehiculoDeCarga(String matricula, String modelo, int cilindros, int potencia, double PMA) {
        super(matricula, modelo, cilindros, potencia);
        this.PMA = PMA;
    } 

    @Override
    public double calcularPrecio() {
        double total =  super.calcularPrecio(); 
        if (this.cilindros < 10) {
            total += this.PMA * PRECIO_FIJO;
        }
        else
            total += this.PMA * PRECIO_FIJO_B;
        
        return total;
    }
}
