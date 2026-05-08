package parcial;

import java.util.Scanner;
import parcial.excepciones.GarageLlenoException;
import parcial.excepciones.HorasInvalidasException;
import parcial.excepciones.PatenteDuplicadaException;
import parcial.excepciones.VehiculoNoEncontradoException;
import parcial.garage.Garage;
import parcial.modelos.Auto;
import parcial.modelos.Camion;
import parcial.modelos.Moto;
import parcial.modelos.Vehiculo;
import parcial.reportes.Reporte;
import parcial.validaciones.Validador;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Garage garage;
    private static Reporte reporte;

    public static void main(String[] args) {
        inicializarGarage();
        reporte = new Reporte(garage);
        menuPrincipal();
        scanner.close();
    }

    private static void inicializarGarage() {
        System.out.println("=== SISTEMA DE GARAGE ===");
        System.out.println("Ingrese la capacidad maxima de espacios del garage:");
        while (true) {
            try {
                int capacidad = Validador.parsearEntero(scanner.nextLine(), "capacidad");
                if (capacidad <= 0) {
                    throw new IllegalArgumentException("La capacidad debe ser mayor a 0.");
                }
                garage = new Garage(capacidad);
                System.out.println("Garage inicializado con " + capacidad + " espacios.\n");
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Intente nuevamente.");
            }
        }
    }

    private static void menuPrincipal() {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("=== SISTEMA DE GARAGE ===");
            System.out.println("1. Registrar ingreso");
            System.out.println("2. Registrar salida");
            System.out.println("3. Listar vehiculos");
            System.out.println("4. Estado del garage");
            System.out.println("5. Reportes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Validador.validarOpcionMenu(scanner.nextLine(), 1, 6);
                procesarOpcion(opcion);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + "\n");
            }
        }
    }

    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1: registrarIngreso(); break;
            case 2: registrarSalida(); break;
            case 3: listarVehiculos(); break;
            case 4: mostrarEstado(); break;
            case 5: generarReporte(); break;
            case 6: System.out.println("Saliendo del sistema. Hasta luego."); break;
        }
    }

    private static void registrarIngreso() {
        System.out.println("\n--- Registrar Ingreso ---");
        System.out.println("Tipo de vehiculo:");
        System.out.println("  1. Moto");
        System.out.println("  2. Auto");
        System.out.println("  3. Camion");
        System.out.print("Seleccione: ");

        int tipo;
        try {
            tipo = Validador.validarOpcionMenu(scanner.nextLine(), 1, 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
            return;
        }

        try {
            System.out.print("Patente: ");
            String patente = scanner.nextLine();
            Validador.validarCampoVacio(patente, "patente");

            System.out.print("Marca: ");
            String marca = scanner.nextLine();
            Validador.validarCampoVacio(marca, "marca");

            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            Validador.validarCampoVacio(modelo, "modelo");

            System.out.print("Horas estimadas: ");
            int horas = Validador.parsearEntero(scanner.nextLine(), "horas");
            Validador.validarHoras(horas);

            Vehiculo vehiculo;
            switch (tipo) {
                case 1:  vehiculo = new Moto(patente, marca, modelo, horas); break;
                case 2:  vehiculo = new Auto(patente, marca, modelo, horas); break;
                default: vehiculo = new Camion(patente, marca, modelo, horas); break;
            }

            garage.registrarIngreso(vehiculo);

        } catch (IllegalArgumentException | HorasInvalidasException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (GarageLlenoException | PatenteDuplicadaException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void registrarSalida() {
        System.out.println("\n--- Registrar Salida ---");
        System.out.print("Patente del vehiculo a retirar: ");

        try {
            String patente = scanner.nextLine();
            Validador.validarCampoVacio(patente, "patente");
            Vehiculo vehiculo = garage.registrarSalida(patente);
            System.out.println("\n--- Resumen de salida ---");
            vehiculo.mostrarDatos();
            System.out.println("Vehiculo retirado correctamente.");
        } catch (IllegalArgumentException | VehiculoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();
    }

    private static void listarVehiculos() {
        System.out.println("\n--- Vehiculos estacionados ---");
        garage.listarVehiculos();
        System.out.println();
    }

    private static void mostrarEstado() {
        System.out.println("\n--- Estado del garage ---");
        garage.mostrarEstado();
        System.out.println();
    }

    private static void generarReporte() {
        System.out.println();
        reporte.generarReporte();
        System.out.println();
    }
}
