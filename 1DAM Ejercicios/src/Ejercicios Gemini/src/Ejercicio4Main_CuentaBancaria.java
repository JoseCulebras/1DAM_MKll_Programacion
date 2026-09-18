public class Ejercicio4Main_CuentaBancaria {
    public static void main(String[] args){

        Ejercicio4_CuentaBancaria cuentaBancaria = new Ejercicio4_CuentaBancaria("Jose");

        System.out.println(cuentaBancaria.mostrarDatos());

        cuentaBancaria.setSaldo(1000);
        cuentaBancaria.setTitular("Andrea");

        System.out.println(cuentaBancaria.mostrarDatos());

        cuentaBancaria.ingresar(500);

        System.out.println(cuentaBancaria.mostrarDatos());

        cuentaBancaria.retirar(1000);

        System.out.println(cuentaBancaria.mostrarDatos());

        cuentaBancaria.retirar(5000);
    }
}
