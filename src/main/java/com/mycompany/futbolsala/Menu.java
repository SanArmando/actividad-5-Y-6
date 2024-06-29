
package com.mycompany.futbolsala;


public class Menu {
   

    static void mostrarMenu() {
        System.out.println("1. Programar partido");
        System.out.println("2. Consultar partidos");
        System.out.println("3. Cancelar programación");
        System.out.println("4. Insertar usuario");
        System.out.println("5. Salir");
        System.out.print("Ingrese una opción: ");
    }

    static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
               // programarPartido();
                break;
            case 2:
               // consultarPartidos();
                break;
            case 3:
               // cancelarProgramacion();
                break;
            case 4:
               // insertarUsuario();
                break;
            case 5:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
        }
    }
}
