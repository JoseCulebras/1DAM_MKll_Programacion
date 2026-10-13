import java.util.Scanner;

public class TEST {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 13: Programa que solicita una frase y muestra el número de caracteres, de espacios, de vocales y de consonantes");
        System.out.println("=========================================================================================================================");

        String frase;
        int contadorCaracteres = 0;
        int contadorEspacios = 0;
        int contadorVocales = 0;
        int contadorConsonantes = 0;

        frase = "Hola Mundo";

        for(int i = 0; i < frase.length(); i++){

            char letra = frase.charAt(i);

            contadorCaracteres++;

            if (frase.charAt(i) == ' '){
                contadorEspacios++;

            }else if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
                contadorVocales++;

            }else{
                contadorConsonantes++;
            }
        }

        System.out.println("\nEl número de caracteres es: " + contadorCaracteres);
        System.out.println("\nEl número de espacios es: " + contadorEspacios);
        System.out.println("\nEl número de vocales es: " + contadorVocales);
        System.out.println("\nEl número de consonantes es: " + contadorConsonantes);
    }
}
