import java.util.Scanner;

public class Ejercicio15ComprobarTipoDia {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Ejercicio 15: Programa que solicita al usuario que seleccione un día de la semana e indica si es un día laborable o no");
        System.out.println("======================================================================================================================");

        int contadorDias = 1;
        int numeroDia;
        String laborable = " es laborable.";
        String noLaborable = " es fin de semana.";

        System.out.println("\n------------DÍAS DE LA SEMANA------------");

        for (DiaSemana dia : DiaSemana.values()){
            System.out.println(contadorDias + ". " +dia.name());
            contadorDias++;
        }

        System.out.println("\nSelecciona un día [1-" + DiaSemana.values().length + "]: ");
        numeroDia = sc.nextInt();

        DiaSemana eleccion = DiaSemana.values()[numeroDia - 1];

        switch (eleccion){
            case LUNES:
                System.out.println("\n" + DiaSemana.LUNES.name().replace("UNES", "unes") + laborable);
                break;

            case MARTES:
                System.out.println("\n" + DiaSemana.MARTES.name().replace("ARTES", "artes") + laborable);
                break;

            case MIERCOLES:
                System.out.println("\n" + DiaSemana.MIERCOLES.name().replace("IERCOLES", "iércoles") + laborable);
                break;

            case JUEVES:
                System.out.println("\n" + DiaSemana.JUEVES.name().replace("UEVES", "ueves") + laborable);
                break;

            case VIERNES:
                System.out.println("\n" + DiaSemana.VIERNES.name().replace("IERNES", "iernes") + laborable);
                break;

            case SABADO:
                System.out.println("\n" + DiaSemana.SABADO.name().replace("ABADO", "ábado") + noLaborable);
                break;

            case DOMINGO:
                System.out.println("\n" + DiaSemana.DOMINGO.name().replace("OMINGO", "omingo") + noLaborable);
                break;
        }
    }

    enum DiaSemana{
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }
}
