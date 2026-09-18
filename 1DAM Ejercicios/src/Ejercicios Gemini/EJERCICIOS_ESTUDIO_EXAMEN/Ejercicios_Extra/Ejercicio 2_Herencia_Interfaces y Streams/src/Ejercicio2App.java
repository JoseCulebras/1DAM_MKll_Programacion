import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio2App {
    public static void main(String[] args) {
        List<ElementoDomotico> casa = new ArrayList<>();

        // Creamos los 5 elementos obligatorios con mezcla de tipos
        casa.add(new Calefaccion("Calefacción Principal"));
        casa.add(new PuertaGaraje("Portón Entrada"));
        casa.add(new Ventana("Ventana Salón"));
        casa.add(new Ventana("Ventana Cocina"));
        casa.add(new Calefaccion("Calefacción Dormitorio"));

        System.out.println("=== 1. ESTADO INICIAL (ORDENADO ALFABÉTICAMENTE) ===");
        // Ordenamos usando una expresión Lambda sobre el nombre (Opción 2 de tus apuntes)
        casa.sort((e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre()));
        casa.forEach(System.out::println);

        System.out.println("\n=== 2. DESACTIVANDO ELEMENTOS ACTIVOS (STREAMS) ===");
        // Usamos streams para filtrar los que estén activos y cambiamos su estado a false (desactivado)
        casa.stream()
                .filter(ElementoDomotico::isActivo)
                .forEach(e -> e.setActivo(false));
        System.out.println("[SISTEMA] -> Todos los elementos activos han sido apagados/bajados.");

        System.out.println("\n=== 3. ESTADO FINAL POST-DESACTIVACIÓN ===");
        casa.forEach(System.out::println);
    }
}