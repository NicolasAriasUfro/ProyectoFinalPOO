package conexionSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionSQL {
    Connection conectar = null;
    public Connection conexion(){

        try{
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/bd_invernadero:3306/bd_invernadero", "root", "");
            //conectar = DriverManager.getConnection("jdbc:mysql://bruselas.ceisufro.cl:3306/bd_invernadero", "accesoinvernadero", "#123invernadero");

            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Conexion: " + e.getMessage());
        }
        return conectar;

    }
}
