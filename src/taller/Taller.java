package taller;

import util.Intervalo;
import util.GestorIO;

/**
 *
 * @author Jorge P.
 */
public class Taller {

    private ColaVehiculos colaVehiculos;
    private Box[] boxes;
    private ColaVehiculos colaPendientesPago;
    private ListaVehiculos listaPagados;

    public static final int NUM_BOXES = 6;

    public Taller() {
        this.boxes = new Box[Taller.NUM_BOXES];
        this.colaPendientesPago = new ColaVehiculos();
        this.listaPagados = new ListaVehiculos();

        for (int i = 0; i < boxes.length; i++) {
            this.boxes[i] = new Box(i + 1, this.colaPendientesPago);
        }
        this.colaVehiculos = new ColaVehiculos();
    }

    /*
     * private void comenzar() { Menu menu = new Menu(); GestorIO gestorIO = new
     * GestorIO(); int opcion; do { menu.mostrar(); opcion = menu.getOpcion();
     * 
     * switch (opcion) { case 5: this.mostrar(); break; default: break; } } while
     * (opcion != 8); }
     */

    public Box getBox() {
        GestorIO gestorIO = new GestorIO();
        int numBox;
        boolean error;
        do {
            gestorIO.out("¿Número box? [1-" + NUM_BOXES + "]:");
            numBox = gestorIO.inInt();
            error = !new Intervalo(1, NUM_BOXES).incluye(numBox);
            if (error) {
                gestorIO.out("Error!!! Debe ser un número de box válido");
            }
        } while (error);
        return boxes[numBox - 1];
    }

    public void mostrar() {
        colaVehiculos.mostrar();
        mostrarBoxes();
    }

    public void mostrarBoxes() {
        for (Box box : boxes) {
            box.mostrar();
        }
    }

    public ColaVehiculos getColaVehiculos() {
        return colaVehiculos;
    }

    public ColaVehiculos getColaPendientesPago() {
        return colaPendientesPago;
    }

    public ListaVehiculos getListaPagados() {
        return listaPagados;
    }
}
