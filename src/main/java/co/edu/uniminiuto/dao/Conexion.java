package co.edu.uniminiuto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/torneo_fs";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    /* private static final String usuario;
    private static final String contra;
    private static final String puerto;
    private static final String servidor;
    private static final String nombreDB;
    private static final String cadena;
    Connection conex;

    public Conexion() {
     /*   this.usuario = "root";
        this.contra = "";
        this.puerto = "3306";
        this.servidor = "localhost";
        this.nombreDB = "torneo_fs";
        this.cadena = "jdbc:mysql://" + this.servidor + ":" + this.puerto + "/" + this.nombreDB;
        this.conex = null;
     */
    //  } 
//retorno
    public static Connection getConectar() throws SQLException {
        return DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
        //return this.conectar();

    }

}

// metodo para la conexion  

/* public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conex = DriverManager.getConnection(this.cadena, this.usuario, this.contra);
            JOptionPane.showMessageDialog(null, "tenemos conexion");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO tenemos conexion");
        } finally {
        }
        return this.conex;
    }*/
