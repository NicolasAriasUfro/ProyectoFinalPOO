package Vista;

import Controllers.SeedController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

import Agricultura.Verdura;

public class Ventana extends JFrame {

    ArrayList<Verdura> verduras;
    Invernadero invernadero = null;

    SeedController seedController = new SeedController();


    public Ventana(){
        frameInit();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Proyecto Invernadero");
        this.setContentPane(ventanaConexion);
        this.setSize(700,500);

        tablaSemillas.setModel(seedController.filtrarDatos(txtBusqueda.getText()));


        btmGuardar.addActionListener(e -> {

            seedController.subirDatosaLaBD(txtNombre.getText(),txtAncho.getText(), txtLargo.getText(), txtCrecimiento.getText());
            limpiarCajas();
            tablaSemillas.setModel(seedController.filtrarDatos(txtBusqueda.getText()));

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
        btmActualizar.addActionListener(e -> {
            int filaSeleccionada = tablaSemillas.getSelectedRow();
            String dao = (String) tablaSemillas.getValueAt(filaSeleccionada,0);

            seedController.actualizarDatos(dao, txtNombre.getText(),txtAncho.getText(), txtLargo.getText(),txtCrecimiento.getText());
            limpiarCajas();
            tablaSemillas.setModel(seedController.filtrarDatos(txtBusqueda.getText()));
        });
        btmEliminar.addActionListener(e -> {

            int filaSeleccionada = tablaSemillas.getSelectedRow();
            int id = (int) tablaSemillas.getValueAt(filaSeleccionada,0);

            seedController.eliminarSemilla(id);
            limpiarCajas();
            tablaSemillas.setModel(seedController.filtrarDatos(txtBusqueda.getText()));
        });
        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                tablaSemillas.setModel(seedController.filtrarDatos(txtBusqueda.getText()));

            }
        });
        btmAbrirInvernadero.addActionListener(e -> {

            if(invernadero != null){
                invernadero.dispose();
            }

            invernadero = new Invernadero();
            invernadero.setVisible(true);
        });
    }


    public void limpiarCajas() {
        txtNombre.setText(null);
        txtAncho.setText(null);
        txtLargo.setText(null);
        txtCrecimiento.setText(null);
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
