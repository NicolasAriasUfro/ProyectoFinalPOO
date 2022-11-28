package Vista;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Invernadero extends JFrame{
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();

    DefaultListModel<String> modeloLista;

    Invernadero(){
        frameInit();
        this.setTitle("Plantacion Invernadero");
        this.setContentPane(ventanaInvernadero);
        this.setSize(1000,500);
        actualizarComboBox();






        comboBox1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                actualizarLabels();
            }
        });

        btmActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //todo obtener un indice del combo box
                actualizarLista("2");
            }
        });
    }

    public void actualizarLista(String id) {



        String[] data = arregloSemillasSegunId(id);
        data[0] = "ID: "+ data[0];
        data[1] = "nombre: "+ data[1];
        data[2] = "ancho: "+ data[2];
        data[3] = "largo: "+ data[3];
        data[4] = "crecimiento: "+ data[4];






        list1.setListData(data);



    }

    public String mostrarDatos(JComboBox<String> comboBox){
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

                comboBox.addItem(registros[0] + ") "+  registros[1]);



            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }

        return registros[0];
    }
    public String[] arregloSemillasSegunId(String id){
        //query para setear las labels
        String[] registros = new String[5];
        String SQL = "select * from semillas where id=" + id +" "; //TODO conseguir el indice de la semilla selecionada
        try {
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                registros[0]= rs.getString("ID");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("ancho");
                registros[3]= rs.getString("largo");
                registros[4]= rs.getString("crecimiento");
            }
            //setear labels
            textNombre1.setText(registros[1]);
            textAncho1.setText(registros[2]);
            textLargo1.setText(registros[3]);
            textCrecimiento1.setText(registros[4]);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        return registros;
    }

    void actualizarLabels(){
        System.out.println(comboBox1.getSelectedItem().toString());



        //query para setear las labels
        String[] registros = new String[5];
        String SQL = "select * from semillas where id=4"; //TODO conseguir el indice de la semilla selecionada
        try {
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                registros[0]= rs.getString("ID");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("ancho");
                registros[3]= rs.getString("largo");
                registros[4]= rs.getString("crecimiento");
            }
            //setear labels
            textNombre1.setText(registros[1]);
            textAncho1.setText(registros[2]);
            textLargo1.setText(registros[3]);
            textCrecimiento1.setText(registros[4]);






        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }




    }








    public void actualizarComboBox(){
        mostrarDatos(comboBox1);
        mostrarDatos(comboBox2);
        mostrarDatos(comboBox3);
        mostrarDatos(comboBox4);

        mostrarDatos(CB1);
    }


    public void setComboBox1(JComboBox<String> comboBox1) {
        this.comboBox1 = comboBox1;
    }
    public void setTextos(String idSemilla,String nombreGrupo){





    }


    private JPanel ventanaInvernadero;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
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
    private JButton actualizarButton;
    private JList<String> list1;
    private JButton btmActualizar1;
    private JComboBox<String> CB1;
    private JButton btmActualizar;
}
