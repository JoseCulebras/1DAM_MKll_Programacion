import java.util.Scanner;

public class Ejercicio3_JGC {
    public static void main (String[] args){
        EntrenamientoRunning();
    }

    public static void EntrenamientoRunning(){
        Scanner scanner = new Scanner(System.in);

        String nombre;
        int edad;
        double peso;
        double altura;
        String sexo;
        double IMC;
        int velocidadInicial;
        int distanciaInicial;
        int caloriasQuemadasIniciales;
        double velocidad;
        double velocidadTotal = 0;
        double distancia;
        double distanciaMax = 0;
        double distanciaTotal = 0;
        double caloriasQuemadas;
        double caloriasQuemadasMax = 0;
        double caloriasQuemadasTotales = 0;

        System.out.println("\nIntroduce tu nombre: ");
        nombre = scanner.next();

        System.out.println("\nIntroduce tu edad: ");
        edad = scanner.nextInt();

        System.out.println("\nIntroduce tu peso (Kg): ");
        peso = scanner.nextDouble();

        System.out.println("\nIntroduce tu altura (m): ");
        altura = scanner.nextDouble();

        System.out.println("\nIntroduce tu sexo: ");
        sexo = scanner.next();

        System.out.println("\nIntroduce tu velocidad inicial (Km/h): ");
        velocidadInicial = scanner.nextInt();

        System.out.println("\nIntroduce tu distancia inicial (Km): ");
        distanciaInicial = scanner.nextInt();

        System.out.println("\nIntroduce tus calorías quemadas iniciales (Kcal): ");
        caloriasQuemadasIniciales = scanner.nextInt();

        IMC = peso / (altura * altura);

        for(int sesiones = 1; sesiones <= 10; sesiones++){
            System.out.println("\nIntroduce tu velocidad (Km/h) (sesión Nº" + sesiones + ": ");
            velocidad = scanner.nextDouble();
            velocidadTotal += velocidad;

            System.out.println("\nIntroduce tu distancia (Km) (sesión Nº" + sesiones + ": ");
            distancia = scanner.nextDouble();
            distanciaTotal += distancia;

            if (distancia > distanciaMax) {
                distanciaMax = distancia;
            }

            System.out.println("\nIntroduce tu velocidad (Kcal) (sesión Nº" + sesiones + ": ");
            caloriasQuemadas = scanner.nextDouble();
            caloriasQuemadasTotales += caloriasQuemadas;

            if (caloriasQuemadas > caloriasQuemadasMax) {
                caloriasQuemadasMax = caloriasQuemadas;
            }
        }

        System.out.println("Hola " + nombre + ", te presentamos la ficha de seguimiento de entrenamiento:");
        System.out.println("\nEdad: " + edad);
        System.out.println("Peso: " + peso + " Kg");
        System.out.println("Altura: " + altura + " m");
        System.out.println("Sexo: " + sexo);
        System.out.println("IMC: " + String.format("%.2f", IMC));
        System.out.println("\nLa media del entrenamiento en 10 sesiones es:");
        System.out.println("\nVelocidad: " + (velocidadTotal / 10) + " Km/h");
        System.out.println("Distancia recorrida: " + (distanciaTotal / 10) + " Km");
        System.out.println("Calorías quemadas: " + (caloriasQuemadasTotales / 10) + " Kcal");
        System.out.println("Máxima distancia recorrida: " + distanciaMax + " Km/h");
        System.out.println("Máximo número de calorías quemadas en una sesión: " + caloriasQuemadasMax + " Kcal");

        if((velocidadTotal / 10) > velocidadInicial){
            System.out.println("\nEnhorabuena!!, la velocidad media de: " + (velocidadTotal / 10) + " Km/h" + " ha superado a la inicial de: " + velocidadInicial + " Km/h");
        }

        if((distanciaTotal / 10) > distanciaInicial){
            System.out.println("\nEnhorabuena!!, la distancia media de: " + (distanciaTotal / 10) + " Km" + " ha superado a la inicial de: " + distanciaInicial + " Km");
        }

        if((caloriasQuemadasTotales / 10) > caloriasQuemadasIniciales){
            System.out.println("\nEnhorabuena!!, las calorías medias de: " + (caloriasQuemadasTotales / 10) + " Kcal" + " han superado a las iniciales de: " + caloriasQuemadasIniciales + " Kcal");
        }
    }
}