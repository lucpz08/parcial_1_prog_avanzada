package parcial.excepciones;

public class VehiculoNoEncontradoException extends Exception {

    public VehiculoNoEncontradoException(String patente) {
        super("No se encontro ningun vehiculo con la patente: " + patente);
    }
}
