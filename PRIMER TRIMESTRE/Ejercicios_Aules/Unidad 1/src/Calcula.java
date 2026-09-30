import java.util.Scanner;
public class Calcula
{
    public static void main(String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        num2 = 6;
        System.out.print("Introduce valor ");
        num1 = sc.nextInt();
        num1 = num1 + 2;
        num2 = num1 / num2;
        num2 = ++num2;
        num1 = num2 * num1++;
        num2 = ++num1%2;
        System.out.println("Resultado = " + num2);
    }
}