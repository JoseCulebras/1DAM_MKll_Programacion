import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Aeropuerto {
    private Map<String, Vuelo> panelVuelos;

    public Aeropuerto(){
        this.panelVuelos = new HashMap<>();
    }

    public void abrirVuelo(String codigo, String destino){
        if(!panelVuelos.containsKey(codigo)){
            panelVuelos.put(codigo, new Vuelo(codigo, destino));
        }
    }

    // COMPLETADO: Declaramos que puede lanzar la excepción y procesamos los Varargs
    public void embarcarPasajeros(String codigo, Pasajero... pasajeros) throws VueloNoEncontradoException{
        if(!panelVuelos.containsKey(codigo)){
            throw new VueloNoEncontradoException("[EXCEPCIÓN] El vuelo " + codigo + " no existe en el panel.");
        }

        // Si existe, recuperamos el vuelo y añadimos los pasajeros uno a uno
        Vuelo vuelo = panelVuelos.get(codigo);

        for(Pasajero p : pasajeros){
            // El Set del vuelo filtrará los DNI duplicados automáticamente gracias a tu equals()
            vuelo.getListaPasajeros().add(p);
        }
    }

    // COMPLETADO: Filtrado y transformación limpia mediante STREAMS
    public void exportarVuelosLlenos(){
        String rutaArchivo = "vuelos_completos.txt";

        // 1. Usamos Streams sobre los VALORES del mapa (panelVuelos.values())
        List<String> lineasAFormatear = panelVuelos.values().stream()
                .filter(v -> v.getListaPasajeros().size() >= 3) // Filtro: 3 o más pasajeros
                .map(v -> "[VUELO: " + v.getCodigoVuelo() + "] -> Destino: " + v.getDestino() + " | Total Pasajeros: " + v.getListaPasajeros().size())
                .collect(Collectors.toList()); // Lo guardamos en una lista de Strings

        // 2. Escribimos la lista resultante en el archivo
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))){
            for(String linea : lineasAFormatear){
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("[SISTEMA] Archivo 'vuelos_completos.txt' generado con éxito.");

        }catch (IOException e){
            System.out.println("Error al procesar el archivo." + e.getMessage());
        }
    }
}
