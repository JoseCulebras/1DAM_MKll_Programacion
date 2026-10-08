import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String entrada = "Jose Culebras";
        String regex = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(\\s+[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)+$";

        if (entrada.matches(regex)){
            System.out.println("Nombre válido");
        }else{
            System.out.println("Nombre inválido");
        }

    }
}