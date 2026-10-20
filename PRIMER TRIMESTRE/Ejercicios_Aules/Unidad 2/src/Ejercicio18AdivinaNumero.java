import java.util.Scanner;

public class Ejercicio18AdivinaNumero {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 18: Programa que piensa aleatoriamente en un número entre 1 y 100 e indicará si el número buscado es mayor o menor y modificará el rango de valores posibles para el siguiente intento");
        System.out.println("================================================================================================================================================================================================");

        int numeroReal;
        int numeroMaximo = 100;
        int numeroMinimo = 1;
        int numero;
        int vidas = 5;

        System.out.println("\nHe pensado en un número entre 1 y 100.\n");

        numeroReal = (int)(Math.random() * numeroMaximo) + 1;

        try {
            do{
                System.out.println("\n[Vidas]: " + vidas);
                System.out.print("\nIntroduce un número (" + numeroMinimo + " - " + numeroMaximo + "): ");
                numero = sc.nextInt();

                if (numero >= numeroMinimo && numero <= numeroMaximo){
                    if (numero == numeroReal){
                        System.out.println("\n¡Has acertado!");

                    }else if(numero < numeroReal){
                        System.out.println("\nEl número buscado es mayor.\n");
                        numeroMinimo = numero + 1;
                        vidas--;

                    }else if(numero > numeroReal){
                        System.out.println("\nEl número buscado es menor.\n");
                        numeroMaximo = numero - 1;
                        vidas--;
                    }

                    if(vidas == 0){
                        System.out.println("\nTe has quedado sin vidas :(\n");
                        System.out.println("El numero era: " + numeroReal);
                    }
                } else {
                    System.out.println("Fuera de rango");
                    vidas--;
                }

            }while (vidas >= 1 && numero != numeroReal);

        }catch(Exception e){
            System.out.println("\nERROR: Solo puedes introducir números enteros.");
        }
    }
}
