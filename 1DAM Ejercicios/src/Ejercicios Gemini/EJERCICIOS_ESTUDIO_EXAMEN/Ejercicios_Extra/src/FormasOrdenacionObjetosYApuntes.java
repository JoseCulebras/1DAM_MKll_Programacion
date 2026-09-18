import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ARCHIVO COMPLETO DE APUNTES CONSOLIDADOS PARA EL EXAMEN
 * Unidades cubiertas: Colecciones Avanzadas, Enums Complejos, Excepciones Propias,
 * Programación Funcional (Streams & Lambdas), Ficheros (Texto/Binarios) y Ordenaciones.
 */
public class FormasOrdenacionObjetosYApuntes {

    // =========================================================================
    // 1. COMPONENTE DE EXCEPCIONES (Checked Exception personalizada)
    // =========================================================================
    public static class SalarioInvalidoException extends Exception {
        private static final long serialVersionUID = 1L;
        public SalarioInvalidoException(String mensaje) { super(mensaje); }
    }

    // =========================================================================
    // 2. COMPONENTE DE ENUMS (Enum avanzado con atributos y constructor)
    // =========================================================================
    public enum Posicion {
        PORTERO(2000, 3000),
        DEFENSA(2500, 3500),
        CENTROCAMPISTA(3500, 4000),
        DELANTERO(4000, 5000);

        private final double min;
        private final double max;

        private Posicion(double min, double max) {
            this.min = min;
            this.max = max;
        }
        public double getMin() { return min; }
        public double getMax() { return max; }
    }

    // =========================================================================
    // 3. CLASE DE ENTIDAD (POO, Encapsulamiento, Criterio de Duplicidad & Serialización)
    // =========================================================================
    public static class Futbolista implements Serializable {
        private static final long serialVersionUID = 1L;

        private final int dorsal; // Identificador único (Clave)
        private final String nombre;
        private final Posicion posicion;
        private final double salario;

        public Futbolista(int dorsal, String nombre, Posicion posicion, double salario) throws SalarioInvalidoException {
            // Regla de negocio que dispara la excepción si falla
            if (salario < posicion.getMin() || salario > posicion.getMax()) {
                throw new SalarioInvalidoException("[EXCEPCIÓN] Salario fuera de rango para " + nombre);
            }
            this.dorsal = dorsal;
            this.nombre = nombre;
            this.posicion = posicion;
            this.salario = salario;
        }

        public int getDorsal() { return dorsal; }
        public String getNombre() { return nombre; }
        public Posicion getPosicion() { return posicion; }
        public double getSalario() { return salario; }

        @Override
        public String toString() {
            return String.format("Dorsal: %d | %-12s | %-14s | Salario: %.2f €", dorsal, nombre, posicion, salario);
        }

        // CONTROL DE DUPLICIDAD: Criterio fundamental para colecciones HashSet o HashMap
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Futbolista that = (Futbolista) o;
            return dorsal == that.dorsal;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dorsal);
        }
    }

    // =========================================================================
    // 4. MÉTODOS AUXILIARES: ESCRITURA Y LECTURA DE FICHEROS
    // =========================================================================

    // Escritura de Texto con BufferedWriter
    public static void exportarAPlaylistTexto(List<Futbolista> lista, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (Futbolista f : lista) {
                bw.write(f.getDorsal() + "#" + f.getNombre() + "#" + f.getPosicion() + "#" + f.getSalario());
                bw.newLine();
            }
            System.out.println("[FICHERO] Datos exportados a texto (" + ruta + ") con éxito.");
        } catch (IOException e) {
            System.out.println("[ERROR] No se pudo escribir el archivo de texto: " + e.getMessage());
        }
    }

    // Respaldo de Objetos Completo (Serialización Directa de Colecciones)
    public static void guardarSeguridadBinaria(List<Futbolista> lista, String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(lista); // Volcado masivo directo del objeto lista
            System.out.println("[FICHERO] Respaldo binario guardado en: " + ruta);
        } catch (IOException e) {
            System.out.println("[ERROR] Error en serialización: " + e.getMessage());
        }
    }

    // =========================================================================
    // 5. PROGRAMA PRINCIPAL (Demostración Práctica de Herramientas)
    // =========================================================================
    public static void main(String[] args) {
        // A) Inicialización de Estructuras Map Avanzadas con límites máximos
        Map<Posicion, Integer> limitesPosicion = new HashMap<>();
        limitesPosicion.put(Posicion.PORTERO, 1);
        limitesPosicion.put(Posicion.DEFENSA, 2);

        // B) Lista dinámica de trabajo
        List<Futbolista> plantilla = new ArrayList<>();

        System.out.println("=== CASO 1: CONTROL AISLADO DE EXCEPCIONES ===");
        // Datos simulados (Incluye un salario erróneo intencionado)
        String[][] datosInscripcion = {
                {"1", "Casillas", "PORTERO", "2500"},
                {"2", "Ramos", "DEFENSA", "3200"},
                {"3", "Piqué", "DEFENSA", "99000"}, // <-- Va a disparar SalarioInvalidoException
                {"4", "Puyol", "DEFENSA", "3000"}
        };

        for (String[] dato : datosInscripcion) {
            // AISLAMIENTO CON TRY-CATCH: Si falla un registro, se captura y el bucle CONTINÚA.
            try {
                int dorsal = Integer.parseInt(dato[0]);
                String nombre = dato[1];
                Posicion pos = Posicion.valueOf(dato[2]);
                double salario = Double.parseDouble(dato[3]);

                Futbolista f = new Futbolista(dorsal, nombre, pos, salario);

                // Validación complementaria contra el Mapa de Topes máximos
                long actualesEnPosicion = plantilla.stream().filter(j -> j.getPosicion() == pos).count();
                if (actualesEnPosicion >= limitesPosicion.getOrDefault(pos, Integer.MAX_VALUE)) {
                    System.out.println("[ERROR RECHAZADO] Cupo máximo excedido para la posición: " + pos + " al intentar meter a " + nombre);
                } else {
                    plantilla.add(f);
                    System.out.println("[SISTEMA] Jugador inscrito: " + nombre);
                }

            } catch (SalarioInvalidoException e) {
                System.out.println(e.getMessage() + " (No se pudo registrar en la base de datos)");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] Posición ortográfica incorrecta.");
            }
        }

        System.out.println("\n=== CASO 2: PROGRAMACIÓN FUNCIONAL (STREAMS) ===");

        // 1. Filtrado elemental y muestra con Referencia a Método
        System.out.println("\n-> Jugadores con Salario Superior a 2800€:");
        plantilla.stream()
                .filter(f -> f.getSalario() > 2800.0)
                .forEach(System.out::println);

        // 2. Mapeo (.map) para transformar flujos de objetos a Strings
        System.out.println("\n-> Listado exclusivo de nombres (Mapeado):");
        List<String> nombres = plantilla.stream()
                .map(Futbolista::getNombre)
                .collect(Collectors.toList());
        System.out.println(nombres);

        // 3. Ordenaciones avanzadas (Conceptos del documento 'Persona')
        System.out.println("\n-> Plantilla Ordenada por Salario (De menor a mayor) - Comparator.comparing:");
        plantilla.stream()
                .sorted(Comparator.comparing(Futbolista::getSalario))
                .forEach(System.out::println);

        // 4. El uso del "Espía" (.peek) y Operación Terminal de conteo
        System.out.println("\n-> Ejecutando auditoría interna con .peek():");
        long totalDefensas = plantilla.stream()
                .filter(f -> f.getPosicion() == Posicion.DEFENSA)
                .peek(d -> System.out.println("   [Peek Audit] Validando defensa: " + d.getNombre()))
                .count();
        System.out.println("Total de defensas validados en el sistema: " + totalDefensas);

        // 5. Cálculos estadísticos con flujos numéricos primitivos (.mapToDouble)
        System.out.println("\n=== CASO 3: ESTADÍSTICAS NUMÉRICAS Y OPTIONAL ===");
        OptionalDouble mediaSalarios = plantilla.stream()
                .mapToDouble(Futbolista::getSalario)
                .average();

        if (mediaSalarios.isPresent()) {
            System.out.printf("El salario medio de la plantilla activa es de: %.2f €\n", mediaSalarios.getAsDouble());
        } else {
            System.out.println("No hay suficientes elementos para computar el promedio.");
        }

        // =========================================================================
        // FICHEROS DE SALIDA
        // =========================================================================
        System.out.println("\n=== CASO 4: PERSISTENCIA ===");
        exportarAPlaylistTexto(plantilla, "plantilla_examen.txt");
        guardarSeguridadBinaria(plantilla, "respaldo_examen.dat");
    }
}

/*
Opción 1: Comparable (Tradicional)

Cómo funciona: La propia clase se firma con implements Comparable<Persona> y se programa el metodo compareTo(Persona otra).

Uso: Collections.sort(lista) o Arrays.sort(array). Es una ordenación rígida ("natural").


Opción 2: Expresión Lambda (Funcional básica)

Cómo funciona: No tocas la clase original. Pasas la regla de ordenación directamente al metodo de ordenación usando una función flecha (p1, p2) -> ....

Uso: lista.sort((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad())


Opción 3: Comparator.comparing (Funcional avanzada)

Cómo funciona: La forma más elegante. Se usa una referencia a un metodo (Clase::getAtributo).

Uso: lista.sort(Comparator.comparing(Persona::getEdad)); o en ingeniería inversa para orden inverso: Comparator.comparing(Persona::getEdad).reversed().
*/