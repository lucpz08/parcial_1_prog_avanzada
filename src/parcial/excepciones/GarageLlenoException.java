package parcial.excepciones;

public class GarageLlenoException extends Exception {

    public GarageLlenoException(int espaciosNecesarios, int espaciosDisponibles) {
        super("Espacio insuficiente. Se necesitan " + espaciosNecesarios
                + " espacios pero solo hay " + espaciosDisponibles + " disponibles.");
    }
}
