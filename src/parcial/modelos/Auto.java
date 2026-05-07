package parcial.modelos;

public class Auto extends Vehiculo {

    public Auto(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    @Override
    public int getEspaciosOcupados() {
        return 2;
    }

    @Override
    public double getTarifaHora() {
        return 1000;
    }
}
