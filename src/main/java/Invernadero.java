import javax.swing.*;

public class Invernadero extends JFrame{

    Invernadero(){
        frameInit();
        this.setContentPane(Plantacion);
        this.setSize(500,500);
    }
    private JTextField textField1;
    private JTextField textField2;
    private JPanel Plantacion;
}
