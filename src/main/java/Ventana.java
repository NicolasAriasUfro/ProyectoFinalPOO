import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexionSQL.conexionSQL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ventana extends JFrame{
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    Ventana(){
        frameInit();
        this.setTitle("Proyecto Invernadero");
        this.setContentPane(ventanaConexion);
        this.setSize(700,500);


        btmGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                subirDatosaLaBD();
                limpiarCajas();

            }
        });
    }

    private void limpiarCajas() {
        txtNombre.setText(null);
        txtAncho.setText(null);
        txtLargo.setText(null);
        txtCrecimiento.setText(null);
    }

    private void subirDatosaLaBD() {
        try{
            String SQL = "insert into semillas (nombre_semilla,ancho,largo,crecimiento) values (?,?,?,?)";
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

    private JPanel ventanaConexion;
    private JTextField txtNombre;
    private JTextField txtAncho;
    private JTextField txtLargo;
    private JButton btmNuevo;
    private JButton btmGuardar;
    private JButton btmEliminar;
    private JButton btmActualizar;
    private JTextField txtCrecimiento;
}
