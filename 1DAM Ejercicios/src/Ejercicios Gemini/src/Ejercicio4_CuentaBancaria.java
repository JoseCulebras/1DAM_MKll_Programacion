public class Ejercicio4_CuentaBancaria {
    private String titular;
    private double saldo;

    public Ejercicio4_CuentaBancaria(String titular){
        this.titular = titular;
    }

    public String getTitular(){
        return titular;
    }

    public void setTitular(String titular){
        this.titular = titular;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void ingresar(double cantidad){
        if(cantidad >= 0){
            this.saldo += cantidad;

            System.out.println("\nSe han añadido " + cantidad + " € a la cuenta");
        }
    }

    public void retirar(double cantidad){
        if(cantidad <= this.saldo){
            this.saldo -= cantidad;

            System.out.println("\nSe han retirado " + cantidad + " € de la cuenta");

        }else if(cantidad > this.saldo){
            System.out.println("\nERROR, No tienes saldo suficiente");
        }
    }

    public String mostrarDatos(){
        return "\nEl titular es " + getTitular() + " con un saldo de " + getSaldo() + " €";
    }
}