package conexionSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class conexionSQL {
    Connection conectar = null;
    public Connection conexion(){

        try{
            //conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd_invernadero", "root", "");
            conectar = DriverManager.getConnection("jdbc:mysql://192.168.50.212:3306/bd_invernadero", "root", "example");
            //conectar = DriverManager.getConnection("jdbc:mysql://bruselas.ceisufro.cl:3306/bd_invernadero", "accesoinvernadero", "#123invernadero");
            Logger.getAnonymousLogger().info("Conexion establecida con exito");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Conexion: " + e.getMessage());
        }
        return conectar;

    }
}
