package co.edu.uniminiuto.dao;

import co.edu.uniminuto.entidades.Partido;
import co.edu.uniminiuto.dao.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartidoDao {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String URL_BASE = "http://localhost/operaciones.php";
//crear 

    public void programarPartido() {
        System.out.print("Ingrese el equipo local: ");
        String equipoLocal = scanner.nextLine();
        System.out.print("Ingrese el equipo visitante: ");
        String equipoVisitante = scanner.nextLine();
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        String fecha = scanner.nextLine();
        System.out.print("Ingrese la hora (hh:mm:ss): ");
        String hora = scanner.nextLine();
// inseertar datos
        try (Connection conn = Conexion.getConectar()) {
            String sql = "INSERT INTO programacion (local, visitante, fecha, hora,estado) VALUES (?, ?, ?, ?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, equipoLocal);
            statement.setString(2, equipoVisitante);
            statement.setString(3, fecha);
            statement.setString(4, hora);
            statement.setString(5, "1");
            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Partido programado con éxito.");
            } else {
                System.out.println("Error al programar el partido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //consultar   
    public void consultarPartidos() {
        try (Connection conn = Conexion.getConectar()) {
            String sql = "SELECT id_nombre, local, visitante, fecha, hora FROM programacion WHERE estado = '1'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            List<Partido> partidos = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id_nombre");
                String equipoLocal = resultSet.getString("local");
                String equipoVisitante = resultSet.getString("visitante");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");
                Partido partido = new Partido(id, equipoLocal, equipoVisitante, fecha, hora);
                partidos.add(partido);
            }
            if (!partidos.isEmpty()) {
                System.out.println("Partidos programados:");
                for (Partido partido : partidos) {
                    System.out.println("ID: " + partido.getId());
                    System.out.println("Equipo Local: " + partido.getEquipoLocal());
                    System.out.println("Equipo Visitante: " + partido.getEquipoVisitante());
                    System.out.println("Fecha: " + partido.getFecha());
                    System.out.println("Hora: " + partido.getHora());
                    System.out.println();
                }
            } else {
                System.out.println("No hay partidos programados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //cancelar   
    public void cancelarProgramacion() {
        System.out.print("Ingrese el ID del partido a cancelar: ");
        int idPartido = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        try (Connection conn = Conexion.getConectar()) {
            String sql = "UPDATE programacion  SET estado = '0' WHERE id_nombre = ? and estado= '1' ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idPartido);
            int estadoModificado = statement.executeUpdate();
            if (estadoModificado > 0) {
                System.out.println("Programación cancelada con éxito.");
            } else {
                System.out.println("No se encontró un partido con ese ID.");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    
  //Actualizar   
    public void actualizarPartido() {
        System.out.print("Ingrese el ID del partido a actualizar: ");
        int idPartido = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        try (Connection conn = Conexion.getConectar()) {
            String sql = "SELECT local, visitante, fecha, hora FROM programacion WHERE id_nombre = ? and estado = '1'";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, idPartido);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String equipoLocal = resultSet.getString("local");
                String equipoVisitante = resultSet.getString("visitante");
                String fecha = resultSet.getString("fecha");
                String hora = resultSet.getString("hora");

                System.out.println("Datos actuales del partido:");
                System.out.println("Equipo Local: " + equipoLocal);
                System.out.println("Equipo Visitante: " + equipoVisitante);
                System.out.println("Fecha: " + fecha);
                System.out.println("Hora: " + hora);

                System.out.print("Ingrese el nuevo equipo local (o Enter para mantener el actual): ");
                String nuevoEquipoLocal = scanner.nextLine();
                if (nuevoEquipoLocal.isEmpty()) {
                    nuevoEquipoLocal = equipoLocal;
                }

                System.out.print("Ingrese el nuevo equipo visitante (o Enter para mantener el actual): ");
                String nuevoEquipoVisitante = scanner.nextLine();
                if (nuevoEquipoVisitante.isEmpty()) {
                    nuevoEquipoVisitante = equipoVisitante;
                }

                System.out.print("Ingrese la nueva fecha (yyyy-mm-dd) (o Enter para mantener la actual): ");
                String nuevaFecha = scanner.nextLine();
                if (nuevaFecha.isEmpty()) {
                    nuevaFecha = fecha;
                }

                System.out.print("Ingrese la nueva hora (hh:mm:ss) (o Enter para mantener la actual): ");
                String nuevaHora = scanner.nextLine();
                if (nuevaHora.isEmpty()) {
                    nuevaHora = hora;
                }

                sql = "UPDATE programacion SET local = ?, visitante = ?, fecha = ?, hora = ? WHERE id_nombre = ?";
                statement = conn.prepareStatement(sql);
                statement.setString(1, nuevoEquipoLocal);
                statement.setString(2, nuevoEquipoVisitante);
                statement.setString(3, nuevaFecha);
                statement.setString(4, nuevaHora);
                statement.setInt(5, idPartido);

                int filasActualizadas = statement.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Partido actualizado con éxito.");
                } else {
                    System.out.println("Error al actualizar el partido.");
                }
            } else {
                System.out.println("No se encontró un partido con ese ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
