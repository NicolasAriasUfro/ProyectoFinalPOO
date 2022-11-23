import Vista.Ventana;

public class Main {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
            }
        });
//Sabiomen estuvo aqui
        //nico estuvo aquí
        // boot 2.0
    }
}
