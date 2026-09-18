// CALEFACCIÓN
class Calefaccion extends ElementoDomotico {
    private double temperatura;

    public Calefaccion(String nombre) {
        super(nombre);
        this.temperatura = 21.5; // Temperatura por defecto
    }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    @Override
    public String toString() {
        return "[Calefacción] " + getNombre() + " | Estado: " + (isActivo() ? "ON" : "OFF") + " | Temp: " + temperatura + "°C";
    }
}

// PUERTA DE GARAJE
class PuertaGaraje extends ElementoDomotico implements Bloqueable {
    private boolean bloqueado;

    public PuertaGaraje(String nombre) {
        super(nombre);
        this.bloqueado = false; // Desbloqueado por defecto
    }

    @Override
    public void bloquear() { this.bloqueado = true; }
    @Override
    public void desbloquear() { this.bloqueado = false; }
    @Override
    public boolean isBloqueado() { return bloqueado; }

    @Override
    public String toString() {
        return "[Puerta Garaje] " + getNombre() + " | Estado: " + (isActivo() ? "SUBIDA" : "BAJADA") + " | Bloqueado: " + (bloqueado ? "SÍ" : "NO");
    }
}

// VENTANA
class Ventana extends ElementoDomotico implements Bloqueable {
    private boolean bloqueado;

    public Ventana(String nombre) {
        super(nombre);
        this.bloqueado = false;
    }

    @Override
    public void bloquear() { this.bloqueado = true; }
    @Override
    public void desbloquear() { this.bloqueado = false; }
    @Override
    public boolean isBloqueado() { return bloqueado; }

    @Override
    public String toString() {
        return "[Ventana] " + getNombre() + " | Persiana: " + (isActivo() ? "SUBIDA" : "BAJADA") + " | Bloqueado: " + (bloqueado ? "SÍ" : "NO");
    }
}