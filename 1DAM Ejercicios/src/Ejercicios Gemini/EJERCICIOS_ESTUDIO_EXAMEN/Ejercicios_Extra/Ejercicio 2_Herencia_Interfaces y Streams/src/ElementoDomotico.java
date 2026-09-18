public abstract class ElementoDomotico {
    private String nombre;
    private boolean activo; // true = encendido/subido, false = apagado/bajado

    public ElementoDomotico(String nombre) {
        this.nombre = nombre;
        this.activo = true; // Por defecto se inician activados según enunciado
    }

    public String getNombre() { return nombre; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    @Override
    public abstract String toString();
}