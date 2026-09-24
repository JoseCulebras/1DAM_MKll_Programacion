public class DatosEmpleado {
    public static void main (String[] args){
        final double PORCENTAJE_RETENCION = 15.0;
        String nombreEmpleado = "Tony Stark";
        int edad = 30;
        double salarioBase = 2500;
        boolean esIndefinido = true;
        char letraInicialApellido = 'S';

        System.out.println("\n- Porcentaje de retención: " + PORCENTAJE_RETENCION + " %");
        System.out.println("\n- Nombre: " + nombreEmpleado);
        System.out.println("\n- Edad: " + edad + " años");
        System.out.println("\n- Salario base: " + salarioBase + " €");
        System.out.println("\n- Es indefinido: "+ esIndefinido);
        System.out.println("\n- Primera letra apellido: " + letraInicialApellido);
    }
}
