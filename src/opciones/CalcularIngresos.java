package opciones;

import taller.Taller;

/**
 * @author Jorge P.
 */
public class CalcularIngresos extends Opcion {

    private Taller taller;

    public CalcularIngresos(Taller taller) {
        super("Cálculo de ingresos");
        this.taller = taller;
    }

    @Override
    public void ejecutar() {
        taller.getListaPagados().mostrarTotalIngresos();;
    }
}