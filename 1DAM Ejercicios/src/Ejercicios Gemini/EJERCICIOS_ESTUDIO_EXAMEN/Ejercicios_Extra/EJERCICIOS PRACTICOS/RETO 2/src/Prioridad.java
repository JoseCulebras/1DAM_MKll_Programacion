public enum Prioridad {
    ROJO(10),
    AMARILLO(60),
    VERDE(120);

    private final int tiempoMaximoEspera;

    private Prioridad(int tiempoMaximoEspera){
        this.tiempoMaximoEspera = tiempoMaximoEspera;
    }

    public int getTiempoMaximoEspera() {return tiempoMaximoEspera;}
}
