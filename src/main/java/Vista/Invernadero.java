package Vista;

import javax.swing.*;

public class Invernadero extends JFrame{

    Invernadero(){
        frameInit();
        this.setTitle("Plantacion Invernadero");
        this.setContentPane(ventanaInvernadero);
        this.setSize(500,500);
    }

    private JPanel ventanaInvernadero;
    private JComboBox comboBox1;
    private JTextField textNombre1;
    private JTextField textAncho1;
    private JTextField textLargo1;
    private JTextField textCrecimiento1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JTextField textNombre2;
    private JTextField textAncho2;
    private JTextField textLargo2;
    private JTextField textCrecimiento2;
    private JTextField textNombre3;
    private JTextField textAncho3;
    private JTextField textLargo3;
    private JTextField textCrecimiento3;
    private JTextField textNombre4;
    private JTextField textAncho4;
    private JTextField textLargo4;
    private JTextField textCrecimiento4;
}
