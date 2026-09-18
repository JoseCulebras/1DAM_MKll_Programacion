public class Comercial extends Empleado{
    private double comision;

    public Comercial(String nombre, double salario, double comision){
        super(nombre, salario);
        this.comision = comision;
    }

    @Override
    public void calcularBono(){
        if (comision > 100){
            salario += 200;
            System.out.println("\n" + nombre + " ha recibido un bono de 200€.");
        }
    }
}
