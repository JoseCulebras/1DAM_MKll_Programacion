import java.util.Scanner;

public class IMC {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        double peso;
        double estatura;
        double IMC;

        System.out.println("\nIntroduce tu peso (kg): ");
        peso = sc.nextDouble();

        System.out.println("\nIntroduce tu estatura (cm)");
        estatura = sc.nextDouble();

        IMC = peso / (Math.pow((estatura / 100), 2));

        System.out.println("\nEl IMC es: " + IMC);
    }
}
