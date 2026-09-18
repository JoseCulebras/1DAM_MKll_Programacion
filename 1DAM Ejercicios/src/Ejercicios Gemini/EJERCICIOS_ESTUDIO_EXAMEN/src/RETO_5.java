import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class RETO_5 {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        double longitudFlecos;
        int totalPiezas = 0;
        double promedioLongitud = 0;
        double totalLongitud = 0;
        int contador = 1;

        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Introduce la longitud de los flecos de tela (cm) (0 para salir)");
        System.out.println("---------------------------------------------------------------");

        ArrayList<PiezaTela5> ListaPiezasTela = new ArrayList<>();

        do{
            System.out.println("\nTela Nº" + contador + ": ");
            longitudFlecos = scanner.nextDouble();

            if(esValido(longitudFlecos)){
                ListaPiezasTela.add(new PiezaTela5(contador, longitudFlecos));
                contador++;

            }else if(longitudFlecos != 0){
                System.out.println("\nERROR");
                System.out.println("Longitud no válida (Debe estar entre 1.0 y 20.0 cm).");
            }

        }while(longitudFlecos != 0);

        for(PiezaTela5 Pieza : ListaPiezasTela){
            totalLongitud += Pieza.getLongitud();
        }

        totalPiezas = ListaPiezasTela.size();

        if (totalPiezas > 0) {
            promedioLongitud = totalLongitud / totalPiezas;
        }

        mostrarResultados(totalPiezas, promedioLongitud);

        if (totalPiezas > 0) {
            guardarFichero(ListaPiezasTela);
        }

        scanner.close();
    }

    public static boolean esValido(double longitud){
        return longitud >= 1 && longitud <= 20;
    }

    public static void mostrarResultados(int totalPiezas, double promedioLongitud){
        System.out.println("\n    RESULTADOS DE LA PRODUCCIÓN     ");
        System.out.println("===================================");
        System.out.println("\n- El total de las piezas válidas son: " + totalPiezas);
        System.out.println("- El promedio de longitud de las piezas válidas es: " + promedioLongitud + " cm");
    }

    public static void guardarFichero(ArrayList<PiezaTela5> Lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("telas.dat"))){
            oos.writeObject(Lista);
            System.out.println("\n[SISTEMA] -> Datos serializados y guardados con éxito en 'telas.dat'");

        }catch (IOException e){
            System.out.println("\n[ERROR] -> No se pudo guardar el archivo: " + e.getMessage());
        }
    }
}

class PiezaTela5 implements Serializable {
    private int id;
    private double longitud;

    public PiezaTela5(int id, double longitud){
        this.id = id;
        this.longitud = longitud;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public double getLongitud() {return longitud;}

    public void setLongitud(double longitud) {this.longitud = longitud;}
}
