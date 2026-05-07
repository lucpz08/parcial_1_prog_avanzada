package parcial.modelos;

public class Camion extends Vehiculo {

    public Camion(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    @Override
    public int getEspaciosOcupados() {
        return 4;
    }

    @Override
    public double getTarifaHora() {
        return 1500;
    }
}
