public class GestionPersonal {
    public static void main(String[] args){

        Empleado[] plantilla = new Empleado[2];

        plantilla[0] = new Comercial("Ana", 1200, 150);
        plantilla[1] = new Comercial("Luis", 1100, 50);

        for(Empleado empleado : plantilla){
            empleado.calcularBono();
            empleado.mostrarDatos();
        }
    }
}
