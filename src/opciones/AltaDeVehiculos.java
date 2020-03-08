package opciones;

import java.util.regex.Pattern;
import vehiculos.Camion;
import vehiculos.Coche;
import vehiculos.Furgoneta;
import vehiculos.Microbus;
import taller.Taller;
import taller.TipoVehiculo;
import vehiculosAbstractos.Vehiculo;
import util.GestorIO;
import util.Intervalo;

/**
 *
 * @author Jorge P.
 */
public class AltaDeVehiculos extends Opcion {

    private Taller taller;

    public AltaDeVehiculos(Taller taller) {
        super("Alta y recepción de vehículos");
        this.taller = taller;
    }

    public Vehiculo recogerNuevoVehiculo() {
        TipoVehiculo tipo = getTipoVehiculo();
        switch (tipo) {
            case COCHE:
                return new Coche(getMatricula(), getModelo(), getCilindros(), getPotencia(), getPlazas());
            case MICROBUS:
                return new Microbus(getMatricula(), getModelo(), getCilindros(), getPotencia(), getPlazas());
            case FURGONETA:
                return new Furgoneta(getMatricula(), getModelo(), getCilindros(), getPotencia(), getPesoMaximo());
            case CAMION:
                return new Camion(getMatricula(), getModelo(), getCilindros(), getPotencia(), getPesoMaximo());
            default:
                return null;
        }
    }

    private String getMatricula() {
        GestorIO gestorIO = new GestorIO();
        String matricula;
        boolean error;
        do {
            gestorIO.out("¿Mátricula? [DDDDLLL]:");
            matricula = gestorIO.inString();
            error = !Pattern.matches(Vehiculo.PATRON_MATRICULA, matricula);
            if (error) {
                gestorIO.out("Error!!! Debe ser una matrícula válida\n");
            }
        } while (error);
        return matricula;
    }

    private String getModelo() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("¿Modelo?: ");
        return gestorIO.inString();
    }

    private TipoVehiculo getTipoVehiculo() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int opcion;
        do {
            gestorIO.out("¿Tipo de vehículo? [1-Coche, 2-Microbús, 3-Furgoneta, 4-Camión]: ");
            opcion = gestorIO.inInt();
            error = !new Intervalo(1, 4).incluye(opcion);
            if (error) {
                gestorIO.out("Error!!! Debe ser un tipo válido\n");
            }
        } while (error);
        switch (opcion) {
            case 1:
                return TipoVehiculo.COCHE;
            case 2:
                return TipoVehiculo.MICROBUS;
            case 3:
                return TipoVehiculo.FURGONETA;
            case 4:
                return TipoVehiculo.CAMION;
            default:
                return null;
        }
    }

    private int getCilindros() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int cilindros;
        do {
            gestorIO.out("¿Cilindros?: ");
            cilindros = gestorIO.inInt();
            error = cilindros < 0;
            if (error) {
                gestorIO.out("Error!!! Debe ser un cilindraje válido\n");
            }
        } while (error);
        return cilindros;
    }

    private int getPotencia() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int potencia;
        do {
            gestorIO.out("Potencia?: ");
            potencia = gestorIO.inInt();
            error = potencia < 0;
            if (error) {
                gestorIO.out("Error!!! Debe ser una potencia válida\n");
            }
        } while (error);
        return potencia;
    }

    private int getPlazas() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int plazas;
        do {
            gestorIO.out("¿Plazas?: ");
            plazas = gestorIO.inInt();
            error = plazas < 0;
            if (error) {
                gestorIO.out("Error!!! Debe ser un número de plazas válido\n");
            }
        } while (error);
        return plazas;
    }

    private int getPesoMaximo() {
        GestorIO gestorIO = new GestorIO();
        boolean error;
        int peso;
        do {
            gestorIO.out("¿Peso máximo?: ");
            peso = gestorIO.inInt();
            error = peso < 0 || peso > 31000;
            if (error) {
                gestorIO.out("Error!!! Debe ser un peso máximo autorizado válido\n");
            }
        } while (error);
        return peso;
    }

    @Override
    public void ejecutar() {
        taller.getColaVehiculos().mete(recogerNuevoVehiculo());
    }
}
