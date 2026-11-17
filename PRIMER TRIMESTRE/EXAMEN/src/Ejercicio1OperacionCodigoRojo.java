import java.util.Scanner;

public class Ejercicio1OperacionCodigoRojo {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String regex = "^[A-ZÁÉÍÓÚÑ]+$";
        String mensaje;

        System.out.println("\nEjercicio 1");

        System.out.println("\nDame un mensaje (ej: AAAAABBBCCAAAA): ");
        mensaje = sc.next();

        while(!mensaje.matches(regex)){
            System.out.println("\nERROR: Debes introducir letras en mayúscula.");
            System.out.println("Introduce otro mensaje por favor: ");
            mensaje = sc.next();
        }

        System.out.println("\n" + comprimir(mensaje));






//        System.out.println("\nLa mensajeActual original es: " + mensaje);
//
//        System.out.println("EL CODIGO ROJO ES: ");
//
//        System.out.println("La secuencia más larga es: ");
//
//        System.out.println("El porcentaje de reducción es 57,00");

    }
    public static String comprimir(String mensaje){

        String letra = "";
        String letraTemp = "";
        int contador = 0;
        String fragmentoMensaje = "";
        String fragmentosMensaje = "";

        for (int i = 0; i < mensaje.length(); i++){
            
            if (i == 0){
                letra = String.valueOf(mensaje.charAt(0));
                letraTemp = letra;
            }
            
            if (i != 0){
                letra = String.valueOf(mensaje.charAt(i));
                letraTemp = String.valueOf(mensaje.charAt(i - 1));
            }
            contador++;

            if(!letra.equals(letraTemp)){
                System.out.println(letraTemp + contador);
            }

//            if (letra.equals(String.valueOf(mensaje.charAt(i + 1)))){
//                contador++;
//
//                fragmentosMensaje = letra + contador;
//            }
        }

        return fragmentosMensaje;
    }

    public static int obtenerSecuenciaMasLarga(String mensaje){

        return 0;
    }

    public static double calcularReduccion(String original, String comprimido){

        return 0;
    }
}
