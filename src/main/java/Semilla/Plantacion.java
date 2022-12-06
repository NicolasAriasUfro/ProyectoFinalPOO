package Semilla;

import java.sql.Date;

public class Plantacion {



    int id_plantacion;
    int ancho;
    int largo;
    Semilla semilla;
    Date fecha_plantacion;


    public Plantacion(int id_plantacion, int ancho, int largo) {
        this.id_plantacion = id_plantacion;
        this.ancho = ancho;
        this.largo = largo;
    }
}
