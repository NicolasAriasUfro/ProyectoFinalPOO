package Agricultura;

import java.sql.Date;

public class Plantacion {



    int id_plantacion;
    int ancho;
    int largo;
    Verdura verdura;
    Date fecha_plantacion;


    public Plantacion(int id_plantacion, int ancho, int largo) {
        this.id_plantacion = id_plantacion;
        this.ancho = ancho;
        this.largo = largo;
    }
    public String toQuery(){

        //esta cadena se tiene que concatenar con el lugar de la base de datos donde se hace la modificacion
        String SQLplantacion = "(id_plantacion,ancho,largo,) values ("+
                this.id_plantacion + ","+
                this.ancho + ","+
                this.largo + ")";

        return SQLplantacion;
    }
}
