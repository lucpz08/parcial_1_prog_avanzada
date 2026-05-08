package parcial.reportes;

import parcial.garage.Garage;
import parcial.modelos.Auto;
import parcial.modelos.Camion;
import parcial.modelos.Moto;
import parcial.modelos.Vehiculo;

public class Reporte {

    private Garage garage;

    public Reporte(Garage garage) {
        this.garage = garage;
    }

    public void generarReporte() {
        System.out.println("========================================");
        System.out.println("           REPORTE DEL GARAGE           ");
        System.out.println("========================================");

        System.out.println("\n--- Vehiculos ---");
        System.out.println("  Total:    " + getTotalVehiculos());
        System.out.println("  Motos:    " + getCantidadPorTipo(Moto.class));
        System.out.println("  Autos:    " + getCantidadPorTipo(Auto.class));
        System.out.println("  Camiones: " + getCantidadPorTipo(Camion.class));

        System.out.println("\n--- Espacios ---");
        System.out.println("  Ocupados:    " + garage.getEspacioOcupado());
        System.out.println("  Disponibles: " + garage.getEspacioDisponible());
        System.out.println("  Total:       " + garage.getCapacidadMaxima());

        System.out.println("\n--- Recaudacion estimada ---");
        System.out.println("  Total: $" + getRecaudacionTotal());

        System.out.println("========================================");
    }

    private int getTotalVehiculos() {
        return garage.getVehiculos().size();
    }

    private int getCantidadPorTipo(Class<?> tipo) {
        int cantidad = 0;
        for (Vehiculo v : garage.getVehiculos()) {
            if (v.getClass() == tipo) {
                cantidad++;
            }
        }
        return cantidad;
    }

    private double getRecaudacionTotal() {
        double total = 0;
        for (Vehiculo v : garage.getVehiculos()) {
            total += v.calcularCosto();
        }
        return total;
    }
}
