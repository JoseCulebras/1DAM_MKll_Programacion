import java.util.Scanner;

public class TEST {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        String codigoEmpleado;
        String regex = ("^[A-ZÑ]{1,2}-[0-9]{4}$");

        System.out.println("\nIntroduce el código: ");
        codigoEmpleado = sc.next();

        if(codigoEmpleado.matches(regex)){
            System.out.println("\nCódigo válido");

        }else{
            System.out.println("\nCódigo inválido");
        }
    }
}
