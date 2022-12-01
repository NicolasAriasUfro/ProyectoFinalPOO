package Vista;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;

public class Invernadero extends JFrame{
    static conexionSQL cc = new conexionSQL();
    static Connection con = cc.conexion();

    DefaultListModel<String> modeloLista;

    ArrayList<JComboBox<String>> arrayCB;
    ArrayList<JList<String>> arrayJlist;

    Invernadero(){
        frameInit();
        this.setTitle("Plantacion Invernadero");
        this.setContentPane(ventanaInvernadero);
        this.setSize(1000,500);



        //Arrays de elementos
        arrayCB = new ArrayList<>(10);
        arrayCB.add(new JComboBox<>());

        arrayCB.add(1,CB1);
        arrayCB.add(2,CB2);
        arrayCB.add(3,CB3);
        arrayCB.add(4,CB4);
        arrayCB.add(5,CB5);

        arrayJlist = new ArrayList<>(10);
        arrayJlist.add(new JList<>());

        arrayJlist.add(1,list1);
        arrayJlist.add(2,list2);
        arrayJlist.add(3,list3);
        arrayJlist.add(4,list4);;
        arrayJlist.add(5,list5);

        actualizarComboBox();












        btmActualizar1.addActionListener(e -> {
            int nroBoton = 1;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            actualizarLista(id, nroBoton);
        });
        btmActualizar2.addActionListener(e -> {
            int nroBoton = 2;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            actualizarLista(id,nroBoton);
        });
        btmActualizar3.addActionListener(e -> {
            int nroBoton = 3;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            actualizarLista(id,nroBoton);
        });
        btmActualizar4.addActionListener(e -> {
            int nroBoton = 4;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            actualizarLista(id,nroBoton);
        });
        btmActualizar5.addActionListener(e -> {
            int nroBoton = 5;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            actualizarLista(id,nroBoton);
        });
    }

    public void actualizarLista(String id,int idLista) {
        /**
         * @param id es el id de la semilla a la cual se le consultan los datos
         * @param idLista es el identificador de la lista a la cual se le cambian los datos
         */

        String[] data = arregloSemillasSegunId(id);
        data[0] = "ID: "+ data[0];
        data[1] = "nombre: "+ data[1];
        data[2] = "ancho: "+ data[2] + " cm.";
        data[3] = "largo: "+ data[3] + " cm.";
        data[4] = "crecimiento: "+ data[4] + " dias.";
        arrayJlist.get(idLista).setListData(data);
    }

    public static String mostrarDatos(JComboBox<String> comboBox){
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
            /*
            textNombre1.setText(registros[1]);
            textAncho1.setText(registros[2]);
            textLargo1.setText(registros[3]);
            textCrecimiento1.setText(registros[4]);

             */
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        return registros;
    }
    //Metodo para poder recibir la fecha de plantacion dentro del invernadero
    public void ingresoFechaPlantacion(){
        Date fechaIngresada;
        fechaIngresada= Date.valueOf(txtFechaPlantacion.getText());
        try {
            String SQL = "alter into plantacion (fecha_plantacion) values (?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error de registro: "+ e.getMessage());
        }





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
        arrayCB.stream().forEach(Invernadero::mostrarDatos);
    }


    private JPanel ventanaInvernadero;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JLabel textNombre1;
    private JLabel textAncho1;
    private JLabel textLargo1;
    private JLabel textCrecimiento1;
    private JButton actualizarButton;
    private JList<String> list1;
    private JComboBox<String> CB1;
    private JButton btmActualizar1;
    private JPanel modulo;
    private JComboBox<String> CB2;
    private JComboBox<String> CB3;
    private JComboBox<String> CB4;
    private JComboBox<String> CB5;
    private JButton btmActualizar2;
    private JButton btmActualizar3;
    private JButton btmActualizar4;
    private JButton btmActualizar5;
    private JList<String> list2;
    private JList<String> list3;
    private JList<String> list4;
    private JList<String> list5;
    private JTextField txtFechaPlantacion;
    private JLabel labelFechaPlantacion;
}
