import java.util.Scanner;

public class Ejercicio12ValidarContrasenya {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio12: Programa que pide introducir una contraseña que debe cumplir unos requisitos determinados mediante matches()");
        System.out.println("=========================================================================================================================");

        String contrasenya;
        String regex = "^(?=.*[A-ZÁÉÍÓÚÑ])(?=.*[a-záéíóúñ])(?=.*[0-9])[a-zA-ZáéíóúñÁÉÍÓÚÑ0-9]{6,12}$";

        System.out.println("Para que la contraseña sea válida: ");
        System.out.println("- Entre 6 y 12 caracteres");
        System.out.println("- Al menos una mayúscula");
        System.out.println("- Al menos una minúscula");
        System.out.println("- Al menos un número");
        System.out.println("\nIntroduce una contraseña: ");
        contrasenya = sc.next();

        if(contrasenya.matches(regex)){
            System.out.println("\nContraseña válida");

        }else{
            System.out.println("\nContraseña inválida");
        }
    }
}
