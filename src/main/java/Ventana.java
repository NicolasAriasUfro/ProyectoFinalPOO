import com.mysql.jdbc.Connection;
import conexionSQL.conexionSQL;

import javax.swing.*;

public class Ventana extends JFrame{
    conexionSQL cc = new conexionSQL();
    Connection con = cc.conexion();
    Ventana(){
        frameInit();
        this.setContentPane(ventanaConexion);
        this.setSize(700,500);
    }
    private JPanel ventanaConexion;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton btmNuevo;
    private JButton btmGuardar;
    private JButton btmEliminar;
    private JButton btmActualizar;
    private JTextField textField4;
}
