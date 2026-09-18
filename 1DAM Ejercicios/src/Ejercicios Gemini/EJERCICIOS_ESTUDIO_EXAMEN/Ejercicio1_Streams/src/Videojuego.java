public class Videojuego {

    private String nombre;
    private String genero;
    private double puntuacion;

    public Videojuego(String nombre, String genero, double puntuacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + genero + " - " + puntuacion;
    }
}
