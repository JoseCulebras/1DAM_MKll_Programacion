import java.util.Scanner;

public class tt {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        double numero_A_Elevar = 0;
        double numero_Elevado = 0;

        System.out.println("Introduce lo que quieres elevar a dos: ");
        numero_A_Elevar = sc.nextDouble();

        numero_Elevado = Math.pow(numero_A_Elevar, 2);

        System.out.println("El número elevado es: " + numero_Elevado);
    }
}
