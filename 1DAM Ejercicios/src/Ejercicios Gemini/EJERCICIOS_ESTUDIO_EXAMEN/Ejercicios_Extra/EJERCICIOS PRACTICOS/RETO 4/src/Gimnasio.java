import java.util.*;

public class Gimnasio {
    // Definimos el mapa: la clave es la Modalidad (String) y el valor la lista de socios inscritos
    Map<String, List<Socio>> distribucionSocios;

    public Gimnasio(){
        this.distribucionSocios = new HashMap<>();
    }

    // METODO 1: Inscribir Socio
    public void inscribirSocio(Socio socio){
        // computeIfAbsent hace magia: si la modalidad del socio no existe en el mapa,
        // crea una nueva lista vacía (ArrayList) y la asocia a esa clave.
        // Después, tanto si ya existía como si la acaba de crear, nos devuelve esa lista y le añadimos (.add) el socio.
        distribucionSocios.computeIfAbsent(socio.getModalidad(), k -> new ArrayList<>()).add(socio);
    }

    // METODO 2: Mostrar socios filtrados y ordenados por modalidad
    public void mostrarSociosPorModalidadOrdenados(String modalidad){
        // Recuperamos la lista de socios de esa modalidad concreta
        List<Socio> socios = distribucionSocios.get(modalidad);

        // Validamos si la modalidad existe o si tiene elementos
        if(socios == null || socios.isEmpty()){
            System.out.println("\n[AVISO] No hay socios inscritos en la modalidad: " + modalidad);
            return;
        }

        System.out.println("\n=== SOCIOS EN " + modalidad + " (Mayores de 18 años, ordenados por peso) ===");
        // Ahora sí, abrimos el Stream sobre la LISTA de socios
        socios.stream()
                .filter(s -> s.getEdad() > 18) // Filtro: Solo mayores de 18
                .sorted(Comparator.comparingDouble(Socio :: getPeso)) // Ordenación: Menor a mayor peso
                .forEach(System.out::println); // Acción final: Imprimir cada uno
    }

    // METODO 3: Informe Estadístico
    public void obtenerInformeEstadistico(){
        if(distribucionSocios.isEmpty()){
            System.out.println("\n[AVISO] El gimnasio no tiene ninguna modalidad activa.");
            return;
        }

        System.out.println("\n=== INFORME ESTADÍSTICO DEL GIMNASIO ===");
        // Recorremos el mapa usando su metodo forEach (Clave, Valor)
        distribucionSocios.forEach((modalidad, listaDeSocios) -> {
            // Calculamos la edad media mediante streams
            double edadMedia = listaDeSocios.stream()
                    .mapToInt(Socio :: getEdad) // Extraemos las edades como un flujo numérico
                    .average()                  // Calculamos el promedio
                    .orElse(0.0);         // Si por alguna razón está vacía, devuelve 0.0

            System.out.println("\nModalidad: " + modalidad);
            System.out.println("  - Total de socios inscritos: " + listaDeSocios.size());
            System.out.println("  - Edad media del grupo: " + String.format("%.1f", edadMedia) + " años");
        });
    }
}
