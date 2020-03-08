import menuopciones.Menu;
import opciones.AltaDeVehiculos;
import opciones.CalcularIngresos;
import opciones.MostrarEstadoAll;
import opciones.MostrarEstadoBox;
import opciones.MoverDeFase;
import opciones.PagarEIrse;
import opciones.ReclamarVehiculo;
import opciones.Salida;
import taller.Taller;

/**
 *
 * @author Jorge P.
 */
public class ITV {

    private Menu menu;
    private Taller taller;

    public ITV() {
        this.menu = new Menu();
        this.taller = new Taller();
        this.menu.añadir(new AltaDeVehiculos(taller));
        this.menu.añadir(new ReclamarVehiculo(taller));
        this.menu.añadir(new MoverDeFase(taller));
        this.menu.añadir(new MostrarEstadoBox(taller));
        this.menu.añadir(new MostrarEstadoAll(taller));
        this.menu.añadir(new PagarEIrse(taller));
        this.menu.añadir(new CalcularIngresos(taller));
        this.menu.añadir(new Salida());
    }

    private void comenzar() {
        do {
            menu.mostrar();
            menu.getOpcion().ejecutar();

        } while (!menu.terminado());
    }
    public static void main(String[] args) {
        new ITV().comenzar();
    }
}
