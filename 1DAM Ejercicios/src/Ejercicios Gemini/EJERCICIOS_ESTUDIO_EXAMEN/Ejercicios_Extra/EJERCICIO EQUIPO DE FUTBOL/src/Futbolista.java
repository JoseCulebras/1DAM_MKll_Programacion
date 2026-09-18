import java.util.Objects;

public class Futbolista {
    private String nombre;
    private int edad;
    private int numero; // Dorsal (Clave única)
    private Posicion posicion;
    private double salario;

    // El constructor lanza la excepción si no se cumple el rango salarial
    public Futbolista(int numero, String nombre, Posicion posicion, double salario, int edad) throws SalarioInvalidoException {
        if (salario < posicion.getSalarioMin() || salario > posicion.getSalarioMax()) {
            throw new SalarioInvalidoException("[EXCEPCIÓN] El salario de " + nombre + " (" + salario + "€) " +
                    "no se ajusta al rango permitido para la posición de " + posicion +
                    " [" + posicion.getSalarioMin() + "€ - " + posicion.getSalarioMax() + "€]");
        }
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
        this.salario = salario;
        this.edad = edad;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public Posicion getPosicion() { return posicion; }
    public void setPosicion(Posicion posicion) { this.posicion = posicion; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    @Override
    public String toString() {
        return String.format("Dorsal: %2d | %-20s | Edad: %d | Posición: %-15s | Salario: %.2f €",
                numero, nombre, edad, posicion, salario);
    }

    // Sobrescribimos equals y hashCode basándonos en el dorsal (número) para evitar duplicados
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista that = (Futbolista) o;
        return numero == that.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}