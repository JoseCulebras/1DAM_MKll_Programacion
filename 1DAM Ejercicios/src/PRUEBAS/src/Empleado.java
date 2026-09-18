public abstract class Empleado{
    protected String nombre;
    protected double salario;

    public Empleado(String nombre, double salario){
        this.nombre = nombre;
        this.salario = salario;
    }

    public abstract void calcularBono();

    public void mostrarDatos(){
        System.out.println("\nNombre: " + nombre + " | Salario: " + salario);
    }
}