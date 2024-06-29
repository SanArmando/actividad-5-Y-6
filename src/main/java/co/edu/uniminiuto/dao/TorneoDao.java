package co.edu.uniminiuto.dao;

/*import co.edu.uniminuto.entidades.Torneo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class TorneoDao {

    Conexion conexion;
    PreparedStatement statement;

    public TorneoDao() {
        conexion = new Conexion();
        this.statement = null;
    }

    public Torneo registrarTorneo(Torneo torneo) {
        Connection con = conexion.getConectar();
        short status = 1;
        String query = "INSERT INTO torneo VALUES (NULL,?,?,?)";
        try {
            if (this.statement == null) {
                this.statement = con.prepareStatement(query);
                // this.statement.setInt(1,torneo.getIdTorneo());
                this.statement.setString(1, torneo.getNombreTorneo());
                this.statement.setInt(2, torneo.getNumDeEquipos());
                this.statement.setShort(3, status);
                int respuesta = this.statement.executeUpdate();
                if (respuesta > 0) {
                    JOptionPane.showMessageDialog(null, "Registrado" + respuesta);
                }
            }
        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    this.statement.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TorneoDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return torneo;
    }

}
*/