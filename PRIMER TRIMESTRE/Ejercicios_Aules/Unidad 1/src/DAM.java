import java.util.Scanner;
public class DAM
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final int YEAR = 2026; //Faltaba inicializar esta variable para luego hacer cálculos con ella
        int age;
        int bornIn; //La variable bornIn necesitaba estar definida por separado con un int
        System.out.print("How old are you this year?"); //El texto del sout no estaba entre comillas
        age = scanner.nextInt(); //Para que se pueda introducir datos por teclado se necesita indicar el scanner
                                 //Para introducir un número correcto es necesario indicar que sea un int como la variable
        bornIn = YEAR - age; //El símbolo de resta era incorrecto
        //-- El resultado debe salir sin decimales ...
        System.out.println("Creo que naciste en ... " + bornIn); //El nombre de la variable de bornIn estaba mal escrito
    }
}
