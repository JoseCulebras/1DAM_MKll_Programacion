import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorGuardado {

    public void guardarPartida(List<Personaje> grupo, String rutaArchivo){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))){
            oos.writeObject(grupo);
            System.out.println("\n[SISTEMA] Datos serializados con éxito.");

        }catch (IOException e){
            System.out.println("\n[ERROR] No se pudo guardar el archivo." + e.getMessage());
        }
    }

    public ArrayList<Personaje> cargarPartida(String rutaArchivo){
        ArrayList<Personaje> grupo = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))){
            grupo = (ArrayList<Personaje>) ois.readObject();

        }catch (IOException e){
            System.out.println("[ERROR] Error al leer el archivo: " + e.getMessage());

        } catch (ClassNotFoundException e){
            System.out.println("[ERROR] No se encontró la clase para los objetos: " + e.getMessage());
        }

        return grupo;
    }
}
