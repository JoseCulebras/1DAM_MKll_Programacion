public class UsoMathYString {
    public static void main (String[] args){
        double radio = 5.0;
        double area = Math.PI * Math.pow(radio, 2);
        String frase = "Aprender Java es divertido";

        System.out.println("\nEl area es: " + String.format("%.2f", area) + " cm²");

        System.out.println("\n" + frase.length());
        System.out.println("\n" + frase.toUpperCase());
        System.out.println("\n" + frase.charAt(0));
    }
}
