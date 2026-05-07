package parcial.validaciones;

import parcial.excepciones.HorasInvalidasException;

public class Validador {

    public static void validarCampoVacio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' no puede estar vacio.");
        }
    }

    public static void validarHoras(int horas) throws HorasInvalidasException {
        if (horas <= 0) {
            throw new HorasInvalidasException(horas);
        }
    }

    public static int validarOpcionMenu(String input, int min, int max) {
        int opcion;
        try {
            opcion = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Debe ingresar un numero entero.");
        }
        if (opcion < min || opcion > max) {
            throw new IllegalArgumentException("Opcion invalida. Ingrese un numero entre " + min + " y " + max + ".");
        }
        return opcion;
    }

    public static int parsearEntero(String input, String nombreCampo) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' debe ser un numero entero.");
        }
    }
}
