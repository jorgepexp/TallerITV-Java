package vehiculosAbstractos;

import java.util.regex.Pattern;

/**
 *
 * @author Jorge P.
 */
public abstract class Vehiculo {

    private String matricula;
    private String modelo;
    protected int cilindros;
    protected int potencia;
    
    private static final int PRECIO_BASE = 15;
    public static final String PATRON_MATRICULA = "\\d{4}[A-Z]{3}";

    public Vehiculo(String matricula, String modelo, int cilindros, int potencia) {
        assert Pattern.matches(PATRON_MATRICULA, matricula);
        this.matricula = matricula;
        this.modelo = modelo;
        this.cilindros = cilindros;
        this.potencia = potencia;
    }
   
    public boolean tieneEsta(String matricula) {
        assert matricula != null;
        return this.matricula.equals(matricula);
    }   
    
    public double calcularPrecio(){
        return this.cilindros * PRECIO_BASE;
    }
    
    @Override
    public String toString() {
        return "Matricula:" + matricula + " Modelo:" + modelo + " Tipo:" /*+ tipoVehiculo.toString()*/;
    }
}
