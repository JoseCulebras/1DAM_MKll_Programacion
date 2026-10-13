import java.util.Scanner;

public class Ejercicio11ComprobarCadenaLetras {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 11: Programa que valida que los caracteres introducidos son letras, tanto mayúsculas como minúsculas");
        System.out.println("==============================================================================================================");

        String caracteres;
        String regex = "^[a-zA-ZáéíóúñÁÉÍÓÚÑ]+$";

        System.out.println("\nIntroduce una cadena de caracteres: ");
        caracteres = sc.next();

        if(caracteres.matches(regex)){
            System.out.println("\nCadena de caracteres válida");

        }else{
            System.out.println("\nCadena de caracteres inválida");
        }
    }
}
