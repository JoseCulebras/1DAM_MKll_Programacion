import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main (String [] args){
        List<Usuario> bancoUsuarios = new ArrayList<>();
        String rutaArchivo = "servidor.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            Usuario usuarioActivo = null;

            while((linea = br.readLine()) != null){
                if(linea.trim().isEmpty()){
                    continue;
                }

                if(linea.startsWith("u-")){
                    String[] trozos = linea.split("-");

                    String usuario = trozos[1];
                    int conexion = Integer.parseInt(trozos[2]);

                    // CORRECCIÓN: Buscamos si el usuario ya fue registrado previamente
                    String usuarioFinal = usuario;
                    usuarioActivo = bancoUsuarios.stream()
                            .filter(u -> u.nombreUsuario.equals(usuarioFinal))
                            .findFirst()
                            .orElse(null);

                    // Si no existe, lo creamos de cero y lo añadimos a la lista principal
                    if(usuarioActivo == null){
                        usuarioActivo = new Usuario(usuario, conexion);
                        bancoUsuarios.add(usuarioActivo);
                    }


                }else if(linea.startsWith("a-") && usuarioActivo != null){
                    String[] trozos = linea.split("-");

                    String descripcion = trozos[1];
                    int codigo = Integer.parseInt(trozos[2]);

                    usuarioActivo.acciones.add(new Accion(descripcion, codigo));
                }
            }

            System.out.println("\n[SISTEMA] Carga completada.");

            // =========================================================================
            // 3. PROCESAMIENTO CON STREAMS (Ejemplo de examen típico)
            // Vamos a filtrar usuarios que tengan algún código de error (>= 400)
            // y ordenarlos de mayor a menor según la cantidad de acciones realizadas.
            // =========================================================================

            List<Usuario> usuariosProcesados = bancoUsuarios.stream()
                    // Filtramos: Nos quedamos solo con usuarios que tengan alguna acción con error (ej. 404, 500)
                    .filter(u -> u.acciones.stream().anyMatch(a -> a.codigoEstado >= 400))
                    // Ordenamos: De mayor a menor cantidad de acciones (uso de .reversed())
                    .sorted(Comparator.comparingInt((Usuario u) -> u.acciones.size()).reversed())
                    // Recolectamos en una lista
                    .collect(Collectors.toList());


            // Mostramos los resultados obtenidos
            System.out.println("\n=== USUARIOS CON ERRORES DETECTADOS (Ordenados por actividad) ===");
            usuariosProcesados.forEach(u ->{
                System.out.println("\nUsusario: " + u.nombreUsuario + " | Acciones totales: " + u.acciones.size());
                u.acciones.forEach(a -> System.out.println("    -> [" + a.codigoEstado + "]" + a.descripcion));
            });

        }catch(IOException e){
            System.out.println("\nError al procesar el archivo.");
        }

    }

    public static class Usuario{
        String nombreUsuario;
        int idConexion;
        Set<Accion> acciones = new LinkedHashSet<>();

        public Usuario(String nombreUsuario, int idConexion){
            this.nombreUsuario = nombreUsuario;
            this.idConexion = idConexion;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }

            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Usuario usuario = (Usuario) o;

            return Objects.equals(nombreUsuario, usuario.nombreUsuario);
        }

        @Override
        public int hashCode(){
            return Objects.hash(nombreUsuario);
        }
    }

    public static class Accion{
        String descripcion;
        int codigoEstado;

        public Accion(String descripcion, int codigoEstado){
            this.descripcion = descripcion;
            this.codigoEstado = codigoEstado;
        }

        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }

            if(o == null || getClass() != o.getClass()){
                return false;
            }

            Accion accion = (Accion) o;

            return Objects.equals(descripcion, accion.descripcion) && Objects.equals(codigoEstado, accion.codigoEstado);
        }

        @Override
        public int hashCode(){
            return Objects.hash(descripcion, codigoEstado);
        }
    }
}
