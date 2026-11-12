import java.util.Scanner;

public class Ejercicio34ComprobarAnagramas {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String primeraPalabraFrase;
        String primeraPalabraFraseLimpia;
        String segundaPalabraFrase;
        String segundaPalabraFraseLimpia;
        String segundaPalabraFraseInvertida = "";
        boolean sonAnagramas = true;
        int[] frecuenciaASCII = new int[256];
        char letraPrimeraPalabra;
        char letraSegundaPalabra;

        System.out.println("Ejercicio 34: Programa que solicita al usuario dos palabras o dos frases y determina si son anagramas");
        System.out.println("=====================================================================================================");

        System.out.print("\nIntroduzca la primera palabra o frase: ");
        primeraPalabraFrase = sc.nextLine();

        System.out.print("\nIntroduzca la segunda palabra o frase: ");
        segundaPalabraFrase = sc.nextLine();

        primeraPalabraFraseLimpia = primeraPalabraFrase.toLowerCase(). replace(" ", "");
        segundaPalabraFraseLimpia = segundaPalabraFrase.toLowerCase(). replace(" ", "");

        if (primeraPalabraFraseLimpia.equals(segundaPalabraFraseLimpia)){
            System.out.println("\nLas palabras o frases deben ser diferentes.");
            return;
        }

        if (primeraPalabraFraseLimpia.length() != segundaPalabraFraseLimpia.length()){
            sonAnagramas = false;

        }else{
            for ()
        }




        for (int i = 0; i < primeraPalabraFraseLimpia.length(); i++){

        }

//        for (int i = segundaPalabraFraseLimpia.length() - 1; i != -1; i--){
//            segundaPalabraFraseInvertida += segundaPalabraFraseLimpia.charAt(i);
//            System.out.print(segundaPalabraFraseInvertida.charAt(i));
//        }
//
//        if (primeraPalabraFrase.contains(" ") || segundaPalabraFrase.contains(" ")){
//            System.out.println("\nSon anagramas");
//
//        }else if(primeraPalabraFrase.equals(segundaPalabraFraseInvertida)){
//            System.out.println("\nSon palabras anagramas");
//
//        }else{
//            System.out.println("\nNo son palabras anagramas");
//        }
    }
}
