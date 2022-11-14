import javax.swing.*;

public class Ventana extends JFrame{
    Ventana(){
        frameInit();
        this.setContentPane(ventanaConexion);
        this.setSize(500,500);
    }
    private JPanel ventanaConexion;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
}
