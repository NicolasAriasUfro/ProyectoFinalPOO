package Vista;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class Invernadero extends JFrame{
    static conexionSQL cc = new conexionSQL();
    static Connection con = cc.conexion();

    DefaultListModel<String> modeloLista;

    ArrayList<JComboBox<String>> arrayCB;
    static ArrayList<JList<String>> arrayJlist;

    ArrayList<JTextField> arrayIngresoFecha;

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
        arrayJlist.add(4,list4);
        arrayJlist.add(5,list5);

        arrayIngresoFecha = new ArrayList<>();
        arrayIngresoFecha.add(new JTextField());
        arrayIngresoFecha.add(1,txtFecha2);
        arrayIngresoFecha.add(2,txtFecha2);
        arrayIngresoFecha.add(3,txtFecha2);
        arrayIngresoFecha.add(4,txtFecha2);
        arrayIngresoFecha.add(5,txtFecha2);





        actualizarComboBox();
        actualizarJlist();




        btmActualizar1.addActionListener(e -> {
            int nroBoton = 1;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            ingresoFechaPlantacion(nroBoton);
            actualizarLista(id, nroBoton);


        });
        btmActualizar2.addActionListener(e -> {
            int nroBoton = 2;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            ingresoFechaPlantacion(nroBoton);
            actualizarLista(id,nroBoton);
        });
        btmActualizar3.addActionListener(e -> {
            int nroBoton = 3;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            ingresoFechaPlantacion(nroBoton);
            actualizarLista(id,nroBoton);
        });
        btmActualizar4.addActionListener(e -> {
            int nroBoton = 4;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            ingresoFechaPlantacion(nroBoton);
            actualizarLista(id,nroBoton);
        });
        btmActualizar5.addActionListener(e -> {
            int nroBoton = 5;
            String opcion = (arrayCB.get(nroBoton).getSelectedItem().toString());
            String id = opcion.substring(0,opcion.indexOf(")"));
            ingresoFechaPlantacion(nroBoton);
            actualizarLista(id,nroBoton);
        });
    }

    public static void actualizarLista(String id, int idLista) {
        /**
         * @param id es el id de la semilla a la cual se le consultan los datos
         * @param idLista es el identificador de la lista a la cual se le cambian los datos
         */
        String idSemilla = id;
        try {
            String SqlForUpdateSemilla = "UPDATE plantacion set semilla_plantada = (?) where id_plantacion = "+idLista;
            PreparedStatement pst= con.prepareStatement(SqlForUpdateSemilla);
            pst.setString(1,idSemilla);
            pst.execute();



        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"No se pudo actaulizar la semilla plantada: " + e.getMessage());
        }

        try {
            String SqlForID = "select semilla_plantada from plantacion where id_plantacion = " + idLista;
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(SqlForID);
            while (rs.next()){
                idSemilla = rs.getString("semilla_plantada");

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al buscar id_semilla: " + e.getMessage());
        }




        String[] data = arregloSemillasSegunId(idSemilla);
        data[0] = "ID: "+ data[0];
        data[1] = "nombre: "+ data[1];
        data[2] = "ancho: "+ data[2] + " cm.";
        data[3] = "largo: "+ data[3] + " cm.";
        data[4] = "crecimiento: "+ data[4] + " dias.";

        String SQL = "select fecha_plantacion from plantacion where id_plantacion =" + idLista;

        try {
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                data[5] =  "Fecha Plantacion: "+rs.getString("fecha_plantacion");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        arrayJlist.get(idLista).setListData(data);
    }
    public static void actualizarLista(int idLista) {
        /**
         * @param idLista es el identificador de la lista a la cual se le cambian los datos
         */
        String idSemilla = "0";


        try {
            String SqlForID = "select semilla_plantada from plantacion where id_plantacion = " + idLista;
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(SqlForID);
            while (rs.next()){
                idSemilla = rs.getString("semilla_plantada");

            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al buscar id_semilla: " + e.getMessage());
        }

        String[] data = arregloSemillasSegunId(idSemilla);
        data[0] = "ID: "+ data[0];
        data[1] = "nombre: "+ data[1];
        data[2] = "ancho: "+ data[2] + " cm.";
        data[3] = "largo: "+ data[3] + " cm.";
        data[4] = "crecimiento: "+ data[4] + " dias.";

        String SQL = "select fecha_plantacion from plantacion where id_plantacion =" + idLista;

        try {
            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                data[5] =  "Fecha Plantacion = "+rs.getString("fecha_plantacion");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        finally {
            arrayJlist.get(idLista).setListData(data);

        }



    }

    public static String mostrarDatos(JComboBox<String> comboBox){
        String[] titulos = {"ID","Nombre","Ancho","Largo","Crecimiento","Fecha plantación"};
        String[] registros = new String[6];

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

                //registros[5] = rs.getString("")...


                comboBox.addItem(registros[0] + ") "+  registros[1]);



            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }

        return registros[0];
    }
    public static String[] arregloSemillasSegunId(String id){
        //query para setear las labels
        String[] registros = new String[6];
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
        return registros;
    }
    //Metodo para poder recibir la fecha de plantacion dentro del invernadero

    public void ingresoFechaPlantacion(int id_plantacion){
        String fechaTexto = arrayIngresoFecha.get(id_plantacion).getText();
        //Date fechaIngresada;
        //fechaIngresada= Date.valueOf(txtFechaPlantacion.getText());
        try {
            //String SQL = "insert into plantacion (fecha_plantacion) values (?) where id_plantacion = " + id_plantacion;
            String SQL = "UPDATE plantacion SET fecha_plantacion = (?) where id_plantacion =" +id_plantacion;


            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, arrayIngresoFecha.get(id_plantacion).getText());
            pst.execute();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error de registro: "+ e.getMessage());
        }
    }





    public void actualizarComboBox(){
        arrayCB.stream().forEach(Invernadero::mostrarDatos);
    }
    public void actualizarJlist(){
        actualizarLista(1);
        actualizarLista(2);
        actualizarLista(3);
        actualizarLista(4);
        actualizarLista(5);




        //arrayJlist.stream().forEach(Invernadero::intermediaParaActualizarLista);
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
    private JTextField txtFecha2;
    private JTextField txtFecha3;
    private JTextField txtFecha4;
    private JTextField txtFecha5;
    private JTextField txtFecha1;
}
