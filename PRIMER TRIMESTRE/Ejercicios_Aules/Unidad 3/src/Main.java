import java.util.*;
public class Main {

    public static void main(String[] args) {
        int n1, n2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el primer número entero a sumar");
        n1 = sc.nextInt();
        System.out.println("Introduce el segundo número entero a sumar");
        n2 = sc.nextInt();
        System.out.println("El resultado de la suma es: " + sumar(n1, n2));
    }

    public static int sumar (int n1, int n2){
        return (n1+n2);
    }
}