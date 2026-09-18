public enum Posicion {
    PORTERO(2000, 3000),
    DEFENSA(2500, 3500),
    CENTROCAMPISTA(3500, 4000),
    DELANTERO(4000, 5000);

    // Atributos encapsulados del Enum
    private final double salarioMin;
    private final double salarioMax;

    // Constructor interno del Enum
    private Posicion(double salarioMin, double salarioMax) {
        this.salarioMin = salarioMin;
        this.salarioMax = salarioMax;
    }

    // Getters para validar las condiciones
    public double getSalarioMin() { return salarioMin; }
    public double getSalarioMax() { return salarioMax; }
}