package parcial.excepciones;

public class PatenteDuplicadaException extends Exception {

    public PatenteDuplicadaException(String patente) {
        super("Ya existe un vehiculo con la patente: " + patente);
    }
}
