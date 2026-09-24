public class CalculosYCondiciones {
    public static void main (String[] args){
        int a = 15;
        int b = 4;
        int suma = a + b;
        int division = a / b;
        int modulo = a % b;
        int edad = 20;
        boolean tieneCarnet = true;
        boolean puedeConducir = false;

        if (edad >= 18 && tieneCarnet){
            puedeConducir = true;
        }

        System.out.println("\n- Suma: " + suma);
        System.out.println("\n- División: " + division);
        System.out.println("\n- Módulo: " + modulo);
        System.out.println("\n- Puede conducir?: " + puedeConducir);

        a++;

        System.out.println("\n- Nuevo valor a: " + a);
    }
}
