import java.util.Scanner;

public class Ejercicio20ContarSumarCifras {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 20: Programa que solicita al usuario un número entero positivo y analiza sus cifras usando un bucle.");
        System.out.println("==============================================================================================================");

        int numero;
        int contadorCifras = 0;
        int ultimaCifra;
        int cifrasPares = 0;
        int cifrasImpares = 0;
        int sumaCifrasPares = 0;

        try {
            System.out.print("\nIntroduce un número entero: ");
            numero = sc.nextInt();

            while (numero > 0) {

                contadorCifras++;

                ultimaCifra = numero % 10;

                if (ultimaCifra % 2 == 0) {
                    cifrasPares++;
                    sumaCifrasPares += ultimaCifra;

                }else{
                    cifrasImpares++;
                }

                numero /= 10;
            }

            System.out.println("\nNúmero de cifras: " + contadorCifras);
            System.out.println("Cifras pares: " + cifrasPares);
            System.out.println("Cifras impares: " + cifrasImpares);
            System.out.println("Suma de las cifras: " + sumaCifrasPares);

        } catch (Exception e) {
            System.out.println("\nERROR: Tienes que poner un número entero.");
        }
    }
}