package Agricultura;

public class Verdura extends Planta{


    public Verdura(String nombre, int ancho, int largo, String crecimiento) {
        this.nombre = nombre;
        this.ancho = ancho;
        this.largo = largo;
        this.crecimiento = crecimiento;
    }
    public Verdura(int id, String nombre, int ancho, int largo, String crecimiento) {
        this.id = id;
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
