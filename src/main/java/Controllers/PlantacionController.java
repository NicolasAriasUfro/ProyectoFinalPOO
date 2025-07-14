package Controllers;

import conexionSQL.conexionSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlantacionController {
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    public void updatePlatationDate(int id_plantacion, String plant_date) {
        try {

            String SQL = "UPDATE plantacion SET fecha_plantacion = (?) where id_plantacion =" +id_plantacion;


            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, plant_date);
            pst.execute();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error al ingresar fecha de plantación: "+ e.getMessage());
        }
    }
}
