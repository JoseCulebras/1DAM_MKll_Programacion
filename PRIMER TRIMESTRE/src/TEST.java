import java.util.Scanner;

public class TEST {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);

        double radio = 0;
        double area = 0;

        System.out.println("Vamos a averiguar el area de un círculo.");
        System.out.println("\nIndica cuánto mide el radio del círculo(cm): ");
        radio = scanner.nextDouble();

        area = Math.PI * Math.pow(radio,2);

        System.out.println("\nEl área resultante del circulo es: " + String.format("2.%f", area));
    }
}
