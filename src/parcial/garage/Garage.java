package parcial.garage;

import java.util.ArrayList;
import parcial.excepciones.GarageLlenoException;
import parcial.excepciones.PatenteDuplicadaException;
import parcial.excepciones.VehiculoNoEncontradoException;
import parcial.modelos.Vehiculo;

public class Garage {

    private int capacidadMaxima;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }

    public void registrarIngreso(Vehiculo vehiculo) throws GarageLlenoException, PatenteDuplicadaException {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(vehiculo.getPatente())) {
                throw new PatenteDuplicadaException(vehiculo.getPatente());
            }
        }
        if (getEspacioDisponible() < vehiculo.getEspaciosOcupados()) {
            throw new GarageLlenoException(vehiculo.getEspaciosOcupados(), getEspacioDisponible());
        }
        vehiculos.add(vehiculo);
        System.out.println("Vehiculo ingresado correctamente.");
    }

    public Vehiculo registrarSalida(String patente) throws VehiculoNoEncontradoException {
        Vehiculo encontrado = buscarPorPatente(patente);
        vehiculos.remove(encontrado);
        return encontrado;
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos estacionados.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println("------------------------------");
            v.mostrarDatos();
        }
        System.out.println("------------------------------");
    }

    public void mostrarEstado() {
        System.out.println("  Capacidad total:     " + capacidadMaxima + " espacios");
        System.out.println("  Espacio ocupado:     " + getEspacioOcupado() + " espacios");
        System.out.println("  Espacio disponible:  " + getEspacioDisponible() + " espacios");
        System.out.println("  Vehiculos en garage: " + vehiculos.size());
    }

    public Vehiculo buscarPorPatente(String patente) throws VehiculoNoEncontradoException {
        for (Vehiculo v : vehiculos) {
            if (v.getPatente().equalsIgnoreCase(patente)) {
                return v;
            }
        }
        throw new VehiculoNoEncontradoException(patente);
    }

    public int getEspacioOcupado() {
        int total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.getEspaciosOcupados();
        }
        return total;
    }

    public int getEspacioDisponible() {
        return capacidadMaxima - getEspacioOcupado();
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }

    public ArrayList<Vehiculo> getVehiculos() { return vehiculos; }
}
