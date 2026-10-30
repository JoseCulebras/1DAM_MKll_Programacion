import java.util.Scanner;

public class Ejercicio32DibujarUnCuadradoHueco {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 32: Programa que solicita al usuario el tamaño (de números enteros positivos) de un cuadrado y lo dibuja con asteriscos y hueco");
        System.out.println("=========================================================================================================================================");

        int base;
        int altura;

        try {
            System.out.print("\nIntroduce el tamaño de la base: ");
            base = sc.nextInt();

            while(base <= 0){
                System.out.print("\nERROR: Introduce un tamaño mayor que 0: ");
                base = sc.nextInt();
            }

            System.out.print("\nIntroduce el tamaño de la altura: ");
            altura = sc.nextInt();

            while(altura <= 0){
                System.out.print("\nERROR: Introduce un tamaño mayor que 0: ");
                altura = sc.nextInt();
            }

            System.out.println("\n\nCuadrado generado:");
            System.out.println("------------------\n");

            for(int i = 0; i < base; i++){
                for(int j = 0; j < altura; j++){
                    if(i == 0 || i == base - 1 || j == 0 || j == altura - 1){
                        System.out.print("*" + "\t");

                    }else{
                        System.out.print("\t");
                    }
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Introduce un valor válido.");
        }
    }
}
