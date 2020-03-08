package opciones;

/**
 *
 * @author Jorge P.
 */
public class Salida extends Opcion{

    private boolean ejecutado;
    
    public Salida() {
        super("Salir del programa");
        this.ejecutado = false;
    }
    
    @Override
    public void ejecutar() {
       this.ejecutado = true;
    }
    
    public boolean ejecutado() {
        return this.ejecutado;
    }
    
}
