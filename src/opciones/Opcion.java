package opciones;

import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public abstract class Opcion {

    private String titulo;
    
    public Opcion(String titulo) {
        this.titulo = titulo;
    }
    
    public void mostrar(int numOpcion) {
        new GestorIO().out("\n" + numOpcion + "." + titulo);
    }
    
    public abstract void ejecutar();
}