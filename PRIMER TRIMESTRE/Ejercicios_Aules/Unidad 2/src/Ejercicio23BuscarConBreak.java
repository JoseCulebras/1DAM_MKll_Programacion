public class Ejercicio23BuscarConBreak {
    public static void main (String[] args){

        System.out.println("Ejercicio 23: Programa que genera números aleatorios entre 1 y 100 hasta que aparezca el número 50");
        System.out.println("==================================================================================================\n");

        int numero = 0;

        while(numero != 50){
            numero = (int)(Math.random() * 100) + 1;

            System.out.println("Número generado: " + numero);

            if(numero == 50){
                System.out.println("\n¡Ha aparecido el número 50!");
                break;
            }
        }

    }
}
