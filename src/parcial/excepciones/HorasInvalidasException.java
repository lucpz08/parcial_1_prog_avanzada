package parcial.excepciones;

public class HorasInvalidasException extends Exception {

    public HorasInvalidasException(int horas) {
        super("Las horas deben ser mayores a 0. Valor ingresado: " + horas);
    }
}
