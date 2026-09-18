import java.util.*;
import java.util.stream.Collectors;

public class AcademiaOnline {
    private List<Inscripcion> registroInscripciones;

    public AcademiaOnline(){
        this.registroInscripciones = new ArrayList<>();
    }

    public void registrarInscripcion(Inscripcion inscripcion){
        registroInscripciones.add(inscripcion);
    }

    public void obtenerInformePorCurso(){
        // 1. Agrupamos perfectamente usando tu groupingBy
        Map<String, List<Inscripcion>> mapaAgrupado = registroInscripciones.stream()
                .collect(Collectors.groupingBy(Inscripcion :: getCurso));

        // 2. Recorremos el mapa local generado
        mapaAgrupado.forEach((curso, listaInscritos) ->{

            // Calculamos el total recaudado
            double totalRecaudado = listaInscritos.stream()
                    .mapToDouble(Inscripcion :: getPrecioPagado)
                    .sum();

            // Contamos cuántos alumnos en ESTE curso tienen completado == true
            long completados = listaInscritos.stream()
                    .filter(Inscripcion :: isCompletado) // Filtramos los que completaron
                    .count();                            // Los contamos

            // Aplicamos la fórmula matemática del porcentaje
            double porcentajeAprobados = (completados * 100.0) / listaInscritos.size();

            // Imprimimos el informe final de la categoría
            System.out.println("\nNombre del curso: " + curso);
            System.out.println("  - Total del dinero recaudado en ese curso: " + totalRecaudado);
            System.out.println("  - Porcentaje de alumnos que han superado el curso: " + String.format("%.1f", porcentajeAprobados) + " %");
        });
    }
}
