import java.util.Scanner;

public class Ejercicio34ComprobarAnagramas {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String primeraPalabraFrase;
        String primeraPalabraFraseLimpia;
        String segundaPalabraFrase;
        String segundaPalabraFraseLimpia;
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
            for (int i = 0; i < primeraPalabraFraseLimpia.length(); i++){
                letraPrimeraPalabra = primeraPalabraFraseLimpia.charAt(i);
                letraSegundaPalabra = segundaPalabraFraseLimpia.charAt(i);

                frecuenciaASCII[letraPrimeraPalabra]++;
                frecuenciaASCII[letraSegundaPalabra]--;
            }

            for (int i = 0; i < frecuenciaASCII.length; i++){
                if (frecuenciaASCII[i] != 0){
                    sonAnagramas = false;
                    break;
                }
            }
        }


        if (sonAnagramas){
            if (primeraPalabraFrase.contains(" ") || segundaPalabraFrase.contains(" ")){
                System.out.println("\nSon anagramas.");

            }else{
                System.out.println("\nSon palabras anagramas.");
            }

        }else{
            if (primeraPalabraFrase.contains(" ") || segundaPalabraFrase.contains(" ")){
                System.out.println("\nNo son anagramas.");

            }else{
                System.out.println("\nNo son palabras anagramas.");
            }
        }
    }
}
