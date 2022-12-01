import java.util.Date;

public class Semilla {
    String nombre;
    int ancho;
    int largo;
    String crecimiento;
    String fechaPlantacion;
    Date fechaCosecha;

    Semilla(String nombre, int ancho, int largo, String crecimiento) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.crecimiento = crecimiento;
    }
}
