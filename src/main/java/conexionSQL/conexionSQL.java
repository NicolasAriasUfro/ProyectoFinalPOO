package conexionSQL;

import com.mysql.jdbc.Connection;
import javax.swing.*;
import java.sql.DriverManager;

public class conexionSQL {
    Connection conectar = null;
    public Connection conexion(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar = (Connection) DriverManager.getConnection("jdbc:mysql://bruselas.ceisufro.cl/bd_invernadero", "accesoinvernadero", "#123invernadero");

            JOptionPane.showMessageDialog(null, "Conexion Exitosa");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de Conexion: " + e.getMessage());
        }
        return conectar;

    }
}
