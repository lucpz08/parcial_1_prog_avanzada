package parcial.modelos;

public class Moto extends Vehiculo {

    public Moto(String patente, String marca, String modelo, int horasEstimadas) {
        super(patente, marca, modelo, horasEstimadas);
    }

    @Override
    public int getEspaciosOcupados() {
        return 1;
    }

    @Override
    public double getTarifaHora() {
        return 700;
    }
}
