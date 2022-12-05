package Semilla;

import java.util.Date;

public class Semilla {


    String nombre;
    int ancho;
    int largo;
    String crecimiento;
    String fechaPlantacion;
    Date fechaCosecha;

    public Semilla(String nombre, int ancho, int largo, String crecimiento) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.crecimiento = crecimiento;
    }

    public String toQuery(){

        //esta cadena se tiene que concatenar con el lugar de la base de datos donde se hace la modificacion
        String SQLsemilla = "(nombre,ancho,largo,crecimiento) values ("+
                nombre + ","+
                ancho + ","+
                largo + ","+
                crecimiento + ")";

        return SQLsemilla;
    }


}
