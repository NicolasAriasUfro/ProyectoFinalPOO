package BackEnd;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Controlador implements Conectable{ //todo implementar de conectable
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    @Override
    public void eliminarDatos(int id) {
        try{
            String SQL = "delete from semillas where id=" +id;

            Statement st = con.createStatement();
            int n = st.executeUpdate(SQL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar registros: "+ e.getMessage());
        }
    }

    @Override
    public void actualizarDatos(String id, String nombre, String ancho, String largo, String crecimiento) {
        try{
            String SQL = "update semillas set nombre =?,ancho=?,largo=?,crecimiento=? where ID = ?";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,nombre);
            pst.setString(2,ancho);
            pst.setString(3,largo);
            pst.setString(4,crecimiento);

            //pasar el id
            pst.setString(5,id);

            pst.execute();

            JOptionPane.showMessageDialog(null,"Registro Actualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de Actualizacion: "+ e.getMessage());
        }
    }

    @Override
    public void subirDatosaLaBD(String nombre, String ancho, String largo, String crecimiento) {
        try{
            String SQL = "insert into semillas (nombre,ancho,largo,crecimiento) values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1,nombre);
            pst.setString(2,ancho);
            pst.setString(3,largo);
            pst.setString(4,crecimiento);

            pst.execute();

            JOptionPane.showMessageDialog(null,"Registro Exitoso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de registros: "+ e.getMessage());
        }
    }
    @Override
    public DefaultTableModel filtrarDatos(String valor){
        String[] titulos = {"ID","Nombre","Ancho","Largo","Crecimiento"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String SQL = "select * from semillas where nombre like '%" + valor+ "%'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                registros[0]= rs.getString("ID");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("ancho");
                registros[3]= rs.getString("largo");
                registros[4]= rs.getString("crecimiento");

                modelo.addRow(registros);
            }
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        return modelo;
    }
}
