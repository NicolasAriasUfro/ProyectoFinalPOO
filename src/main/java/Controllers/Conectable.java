package Controllers;

import javax.swing.table.DefaultTableModel;

public interface Conectable {
    void eliminarSemilla(int id);

    void actualizarDatos(String id, String nombre, String ancho, String largo, String crecimiento);

    void subirDatosaLaBD(String nombre, String ancho, String largo, String crecimiento);

    DefaultTableModel filtrarDatos(String valor);
}
