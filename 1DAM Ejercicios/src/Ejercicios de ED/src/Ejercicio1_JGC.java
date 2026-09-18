public class Ejercicio1_JGC {
    public static void main (String[] args){
        //auditoriaEmpresa();
    }

    public static boolean auditoriaEmpresa(int salarioJefe, int salarioEncargado, int salarioOficinistas, int numeroOficinistas, boolean proyectosTerminados, int presupuestoEmpresa){

        int gastosGlobales;

        if(!proyectosTerminados){
            System.out.println("\nNo apto");
            System.out.println("No ha pasado la auditoría ya que no ha terminado los proyectos acordados");
            return false;

        }else{
            gastosGlobales = salarioJefe + salarioEncargado + (salarioOficinistas * numeroOficinistas);

            if(gastosGlobales > 20000){
                System.out.println("\nNo apto");
                System.out.println("No ha pasado la auditoría ya que el gasto en personal es de " + gastosGlobales + " y excede el límite mensual de 20.000 euros");
                return false;

            }else{
                if(presupuestoEmpresa > 100000){
                    System.out.println("\nNo apto");
                    System.out.println("No ha pasado la auditoría ya que el presupuesto asignado de " + presupuestoEmpresa + " excede el límite establecido en 100.000 euros");
                    return false;

                }else{
                    System.out.println("\nApto");
                    System.out.println("Enhorabuena!! Ha pasado la auditoría, nos vemos el año que viene");
                    return true;
                }
            }
        }
    }
}