import java.util.*;

public class Taller {
    private Map<String, List<Coche>> lineasDeTrabajo;

    public Taller(){
        this.lineasDeTrabajo = new HashMap<>();
    }

    public void registrarAverias(Coche c, String... descripciones){
        for(String descripcion : descripciones){
            c.getHistorialAverias().add(descripcion);
        }
    }

    public void asignarLinea(String tipoAveria, Coche c){
        if(!lineasDeTrabajo.containsKey(tipoAveria)){
            lineasDeTrabajo.put(tipoAveria, new ArrayList<>());
        }

        List<Coche> listaDeCoches = lineasDeTrabajo.get(tipoAveria);

        if(!listaDeCoches.contains(c)){
            listaDeCoches.add(c);
            System.out.println("\n[SISTEMA] Coche con matrícula: " + c.getMatricula() + " añadido en la categoría de \"" + tipoAveria + "\"");

        }else{
            System.out.println("\n[AVISO] El coche con matrícula: " + c.getMatricula() + " ya está añadido en la categoría de \"" + tipoAveria + "\"");
        }
    }

    public void despacharLinea(String tipoAveria){
        if(!lineasDeTrabajo.containsKey(tipoAveria)){
            System.out.println("\nLa categoría de avería especificada no existe.");
            return;
        }

        List<Coche> listaDeCoches = lineasDeTrabajo.get(tipoAveria);

        if(!listaDeCoches.isEmpty()){
            Coche cochePrioritario = listaDeCoches.stream()
                    .max(Comparator.comparingInt(Coche::getKilometraje))
                    .get();

            System.out.println("\nLa matrícula del coche con más kilómetros es: " + cochePrioritario.getMatricula());

            lineasDeTrabajo.remove(cochePrioritario);
            System.out.println("\n[SISTEMA] Coche con matrícula: " + cochePrioritario.getMatricula() + ", ha sido eliminado del sistema.");

        }else{
            System.out.println("\n[SISTEMA] No hay coches esperando en la línea de " + tipoAveria);
        }
    }
}
