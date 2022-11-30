package Vista;

import Vista.Invernadero;

import conexionSQL.conexionSQL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;

public class Ventana extends JFrame{
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();


    public Ventana(){
        frameInit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Proyecto Invernadero");
        this.setContentPane(ventanaConexion);
        this.setSize(700,500);

        mostrarDatos();


        btmGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subirDatosaLaBD();
                limpiarCajas();
                mostrarDatos();

            }
        });
        tablaSemillas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int filaSeleccionada = tablaSemillas.rowAtPoint(e.getPoint());

                txtNombre.setText((String) tablaSemillas.getValueAt(filaSeleccionada,1));
                txtAncho.setText((String) tablaSemillas.getValueAt(filaSeleccionada,2));
                txtLargo.setText((String) tablaSemillas.getValueAt(filaSeleccionada,3));
                txtCrecimiento.setText((String) tablaSemillas.getValueAt(filaSeleccionada,4));



            }
        });
        btmActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
                limpiarCajas();
                mostrarDatos();
            }
        });
        btmEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarDatos();
                limpiarCajas();
                mostrarDatos();
            }
        });
        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                filtrarDatos(txtBusqueda.getText());
            }
        });
        btmAbrirInvernadero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Invernadero().setVisible(true);
            }
        });
    }

    private void eliminarDatos() {
        int filaSeleccionada = tablaSemillas.getSelectedRow();
        try{
            String SQL = "delete from semillas where id=" + tablaSemillas.getValueAt(filaSeleccionada,0);

            Statement st = (Statement) con.createStatement();
            int n = st.executeUpdate(SQL);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar registros: "+ e.getMessage());
        }


    }

    private void actualizarDatos() {
        //Arreglar el Bug de duplicado en Actualizar
        try{
            String SQL = "update semillas set nombre =?,ancho=?,largo=?,crecimiento=? where ID = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(SQL);

            int filaSeleccionada = tablaSemillas.getSelectedRow();
            String dao = (String) tablaSemillas.getValueAt(filaSeleccionada,0);



            pst.setString(1,txtNombre.getText());
            pst.setString(2,txtAncho.getText());
            pst.setString(3,txtLargo.getText());
            pst.setString(4,txtCrecimiento.getText());

            //pasar el id
            pst.setString(5,dao);

            pst.execute();

            JOptionPane.showMessageDialog(null,"Registro Actualizado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de Actualizacion: "+ e.getMessage());
        }
    }

    private void limpiarCajas() {
        txtNombre.setText(null);
        txtAncho.setText(null);
        txtLargo.setText(null);
        txtCrecimiento.setText(null);
    }

    private void subirDatosaLaBD() {
        try{
            String SQL = "insert into semillas (nombre,ancho,largo,crecimiento) values (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(SQL);
            pst.setString(1,txtNombre.getText());
            pst.setString(2,txtAncho.getText());
            pst.setString(3,txtLargo.getText());
            pst.setString(4,txtCrecimiento.getText());

            pst.execute();

            JOptionPane.showMessageDialog(null,"Registro Exitoso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error de registros: "+ e.getMessage());
        }
    }
    public void mostrarDatos(){
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

                modelo.addRow(registros);
                tablaSemillas.setModel(modelo);


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
    }
    public void filtrarDatos(String valor){
        String[] titulos = {"ID","Nombre","Ancho","Largo","Crecimiento"};
        String[] registros = new String[5];

        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        String SQL = "select * from semillas where nombre like '%" + valor+ "%'";
        try {
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                registros[0]= rs.getString("ID");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("ancho");
                registros[3]= rs.getString("largo");
                registros[4]= rs.getString("crecimiento");

                modelo.addRow(registros);
                tablaSemillas.setModel(modelo);


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error al cargar los datos: " + e.getMessage());
        }
    }

    private JPanel ventanaConexion;
    private JTextField txtNombre;
    private JTextField txtAncho;
    private JTextField txtLargo;
    private JButton btmNuevo;
    private JButton btmGuardar;
    private JButton btmEliminar;
    private JButton btmActualizar;
    private JTextField txtCrecimiento;
    private JTable tablaSemillas;
    private JTextField txtBusqueda;
    private JButton btmAbrirInvernadero;
}
