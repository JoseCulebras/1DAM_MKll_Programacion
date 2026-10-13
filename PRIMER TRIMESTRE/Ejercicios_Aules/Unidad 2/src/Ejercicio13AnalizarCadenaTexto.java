import java.util.Scanner;

public class Ejercicio13AnalizarCadenaTexto {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 13: Programa que solicita una frase y muestra el número de caracteres, de espacios, de vocales y de consonantes");
        System.out.println("=========================================================================================================================");

        String frase;

        System.out.println("\nIntroduce una frase: ");
        frase = sc.nextLine();

        for(int i = 0; i < frase.length(); i++){

            int contadorEspacios = 0;

            if (frase.contains(" ")){
                contadorEspacios++;
            }
        }

        System.out.println(c);
    }
}
