package Vista;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Invernadero extends JFrame{
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();

    Invernadero(){
        frameInit();
        this.setTitle("Plantacion Invernadero");
        this.setContentPane(ventanaInvernadero);
        this.setSize(1000,500);
        actualizarComboBox();
    }
    public void mostrarDatos(JComboBox comboBox){
        String[] titulos = {"ID","Nombre","Ancho","Largo","Crecimiento"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String SQL = "select * from semillas";
        try {
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                registros[0]= rs.getString("ID");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("ancho");
                registros[3]= rs.getString("largo");
                registros[4]= rs.getString("crecimiento");

                comboBox.addItem(registros[0] + registros[1]);



            }
            comboBox1.addItem("Hola");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
    }








    public void actualizarComboBox(){
        mostrarDatos(comboBox1);
        mostrarDatos(comboBox2);
        mostrarDatos(comboBox3);
        mostrarDatos(comboBox4);
    }


    public void setComboBox1(JComboBox<String> comboBox1) {
        this.comboBox1 = comboBox1;
    }

    private JPanel ventanaInvernadero;
    private JComboBox<String> comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JLabel textNombre1;
    private JLabel textNombre2;
    private JLabel textNombre3;
    private JLabel textNombre4;
    private JLabel textAncho1;
    private JLabel textAncho2;
    private JLabel textAncho3;
    private JLabel textAncho4;
    private JLabel textLargo1;
    private JLabel textLargo2;
    private JLabel textLargo3;
    private JLabel textLargo4;
    private JLabel textCrecimiento4;
    private JLabel textCrecimiento1;
    private JLabel textCrecimiento2;
    private JLabel textCrecimiento3;
}
