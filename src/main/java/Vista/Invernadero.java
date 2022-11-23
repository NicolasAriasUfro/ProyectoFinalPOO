package Vista;

import javax.swing.*;

public class Invernadero extends JFrame{

    Invernadero(){
        frameInit();
        this.setContentPane(Plantacion);
        this.setSize(500,500);
    }

    private JPanel Plantacion;
}
