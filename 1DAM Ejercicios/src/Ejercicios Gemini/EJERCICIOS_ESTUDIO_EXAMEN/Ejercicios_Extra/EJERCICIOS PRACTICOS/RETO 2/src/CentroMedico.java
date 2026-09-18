import java.io.*;
import java.util.*;

public class CentroMedico {
    private Map<Prioridad, List<Paciente>> colasEspera;

    public CentroMedico(){
        // CORREGIDO: Inicializamos el mapa una vez y lo rellenamos en el bucle
        this.colasEspera = new HashMap<>();

        for (Prioridad p : Prioridad.values()){
            this.colasEspera.put(p, new ArrayList<>());
        }
    }

    public void admitirPaciente(Paciente paciente) throws SinDuplicadoException{
        // CORREGIDO: Buscamos si el SIP existe en CUALQUIERA de las listas del mapa
        boolean existeSIP = colasEspera.values().stream()
                .flatMap(List :: stream)
                .anyMatch(p -> p.getSip().equals(paciente.getSip()));

        if(existeSIP){
            throw new SinDuplicadoException("[EXCEPCION] Ya existe un paciente con ese número SIP: " + paciente.getSip() + " ya se encuentra en urgencias.");

        }else{
            // CORREGIDO: Obtenemos la lista de su prioridad y lo añadimos
            colasEspera.get(paciente.getPrioridad()).add(paciente);
        }
    }

    public void procesarFicheroHistorial(String rutaArchivo){
        // Usamos la ruta que nos pasan por parámetro
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;

            while((linea = br.readLine()) != null){
                if(linea.trim().isEmpty()){
                    continue;
                }

                // CORREGIDO: Parsear la línea y extraer los campos
                String[] datos = linea.split(";");
                String sip = datos[0];
                String nombre = datos[1];
                int edad = Integer.parseInt(datos[2]);
                Prioridad prioridad = Prioridad.valueOf(datos[3]); // Convierte el String "ROJO" al Enum Prioridad.ROJO

                Paciente paciente = new Paciente(sip, nombre, edad, prioridad);

                try{
                    admitirPaciente(paciente);

                }catch (SinDuplicadoException e){
                    System.out.println(e.getMessage() + " -> Saltando línea...");
                }
            }

        }catch (IOException e){
            System.out.println("Error de lectura de archivo: " + e.getMessage());
        }
    }

    public void mostrarPacientesUrgentesOrdenados(){
        System.out.println("\n=== LISTADO DE PACIENTES URGENTES (ROJO/AMARILLO) ORDENADOS POR EDAD ===");
        // CORREGIDO: Primero aplicamos flatMap para convertirlo en un Stream de Pacientes individuales
        colasEspera.values().stream()
                .flatMap(List :: stream) // Aplanamos: de Stream<List<Paciente>> a Stream<Paciente>
                .filter(p -> p.getPrioridad() == Prioridad.ROJO || p.getPrioridad() == Prioridad.AMARILLO)
                .sorted(Comparator.comparingInt(Paciente :: getEdad).reversed()) // De mayor a menor edad
                .forEach(System.out::println);
    }
}
