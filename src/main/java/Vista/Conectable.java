package Vista;

public interface Conectable {
    void eliminarDatos();

    void actualizarDatos();

    void limpiarCajas();

    void subirDatosaLaBD();

    void filtrarDatos(String valor);
}
