package parcial.modelos;

import parcial.interfaces.Calculable;
import parcial.interfaces.Mostrable;

public abstract class Vehiculo implements Calculable, Mostrable {

    private String patente;
    private String marca;
    private String modelo;
    private int horasEstimadas;

    public Vehiculo(String patente, String marca, String modelo, int horasEstimadas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.horasEstimadas = horasEstimadas;
    }

    public abstract int getEspaciosOcupados();
    public abstract double getTarifaHora();

    @Override
    public double calcularCosto() {
        return horasEstimadas * getTarifaHora();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("  Patente:          " + patente);
        System.out.println("  Marca:            " + marca);
        System.out.println("  Modelo:           " + modelo);
        System.out.println("  Horas estimadas:  " + horasEstimadas);
        System.out.println("  Espacios ocupados:" + getEspaciosOcupados());
        System.out.println("  Costo estimado:   $" + calcularCosto());
    }

    public String getPatente() { return patente; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getHorasEstimadas() { return horasEstimadas; }
}
