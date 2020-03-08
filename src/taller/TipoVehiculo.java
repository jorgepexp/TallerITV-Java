package taller;

import util.Intervalo;

/**
 *
 * @author Rober
 */
public enum TipoVehiculo {
    COCHE, FURGONETA, MICROBUS, CAMION, NADA;
    
    public static final TipoVehiculo tipoSegunIndice(int indice) {
        assert new Intervalo(1,4).incluye(indice);
        
        switch(indice) {
            case 1:
                return COCHE;
            case 2:
                return FURGONETA;
            case 3:
                return MICROBUS;
            case 4:
                return CAMION;
            default:
                return NADA;
        }
    }
    
    @Override
    public String toString() {
        switch(this) {
            case COCHE:
                return "Coche";
                
            case FURGONETA:
                return "Furgoneta";
                
            case MICROBUS:
                return "Microbús";
                
            case CAMION:
                return "Camión";
        }
        return null;
    }
}
