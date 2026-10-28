import java.util.Scanner;

public class Ejercicio27EliminarNumeroArray {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 27: Programa que genera aleatoriamente 20 números entre el 1 y el 50, lo busca y, si aparece, lo elimina y muestra el array");
        System.out.println("=====================================================================================================================================");

        int[] arrayNumeros = new int[20];
        int elementosValidos = 20;
        int numero;
        boolean encontrado = false;
        int indiceNumeroEncontrado = 0;

        System.out.println("\nNúmeros generados: ");
        for(int i = 0; i < arrayNumeros.length; i++){

            arrayNumeros[i] = (int)(Math.random() * 50) + 1;
            System.out.print(arrayNumeros[i] + " ");
        }

        try {
            System.out.print("\n\nIntroduce el número que quieres eliminar: ");
            numero = sc.nextInt();

            while(numero > 50 || numero < 1){
                System.out.print("\nIntroduce otro número dentro del rango (1-50): ");
                numero = sc.nextInt();
            }

            for(int i = 0; i < elementosValidos; i++){
                if(!encontrado){
                    if(numero == arrayNumeros[i]){
                        indiceNumeroEncontrado = i;
                        encontrado = true;
                    }
                }
            }

            if(encontrado){
                System.out.println("\nArray después de eliminar la primera aparición: ");
                for(int i = indiceNumeroEncontrado; i < elementosValidos - 1; i++){
                    arrayNumeros[i] = arrayNumeros[i + 1];
                }

                elementosValidos--;

                for(int i = 0; i < elementosValidos; i++){
                    if(arrayNumeros[i] != 0){
                        System.out.print(arrayNumeros[i] + " ");
                    }
                }

            }else{
                System.out.println("\nEse número no se encuentra en el array.");
            }

        } catch (Exception e) {
            System.out.println("\nERROR: Debes introducir un valor válido.");
        }
    }
}
