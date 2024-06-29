package com.mycompany.futbolsala;

//import co.edu.uniminiuto.dao.Conexion;
import com.mycompany.futbolsala.Menu;
//import co.edu.uniminiuto.dao.TorneoDao;
import co.edu.uniminuto.entidades.Torneo;
import java.util.Scanner;
import co.edu.uniminiuto.dao.PartidoDao;
// pricipal

public class FutbolSala {
       private static final PartidoDao partidoDao = new PartidoDao();

    public static void main(String[] args) {
        //Conexion conexion = new Conexion();
        //conexion.getConectar();
        Scanner scanner = new Scanner(System.in);
        short tor_numdeequipos = 12;
        short tor_status = 1;
        Torneo torneo = new Torneo("Super capeones", tor_numdeequipos, tor_status);
       // TorneoDao dao = new TorneoDao();
       // dao.registrarTorneo(torneo);

        int opcion;
        do {
            Menu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea
            procesarOpcion(opcion);
        } while (opcion != 5);

    }

    static void Menu() {
        System.out.println("1. Programar partido");
        System.out.println("2. Consultar partidos");
        System.out.println("3. Cancelar programación");
        System.out.println("4. Actualizar Partido");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                partidoDao.programarPartido();
                break;
            case 2:
                partidoDao.consultarPartidos();
                break;
            case 3:
                partidoDao.cancelarProgramacion(); 
                break;
            case 4:
                partidoDao.actualizarPartido(); 
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }

}
