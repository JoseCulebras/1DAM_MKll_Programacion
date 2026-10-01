import java.util.Scanner;

public class GestionNotasAlumnos {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String nombre = "";
        String regex = "^[a-zA-Z\\s+$]";
        boolean valido = false;

        System.out.println("\nIntroduce el nombre del alumno: ");
        nombre = sc.nextLine();

        while(valido){
            if (!nombre.matches(regex)){
                System.out.println("Ese nombre lo es válido.");
                System.out.println("Introduce otro nombre por favor: ");
                nombre = sc.nextLine();
            }else{
                valido = true;
            }
        }

    }
}
