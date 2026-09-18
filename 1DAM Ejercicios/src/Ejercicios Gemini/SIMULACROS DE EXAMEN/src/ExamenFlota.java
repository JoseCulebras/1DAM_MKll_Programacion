import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExamenFlota{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        int opcion;
        int id;
        double capacidadCarga = 0;
        String matricula = "";
        int totalFurgonetas;
        double capacidadCargaTotal = 0;
        double mayorCapacidadCarga = 0;
        int idBusqueda = 0;

        ArrayList<Furgoneta> ListaFurgonetas = cargarFichero();

        do{
            System.out.println("\n=== GESTIÓN DE FLOTA DE FURGONETAS ===");
            System.out.println("1. Registrar nueva furgoneta");
            System.out.println("2. Mostrar flota completa y estadísticas");
            System.out.println("3. Buscar furgoneta por ID");
            System.out.println("4. Salir y Guardar");

            System.out.println("\nIntroduce la opción que quieras: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:

                    System.out.println("\nRegistra una nueva furgoneta: ");
                    id = ListaFurgonetas.size() + 1;

                    System.out.println("\nIntroduce la matrícula de la furgoneta: ");
                    matricula = sc.next();

                    System.out.println("\nIntroduce la capacidad de carga: ");
                    capacidadCarga = sc.nextDouble();

                    if(capacidadValida(capacidadCarga)){
                        ListaFurgonetas.add(new Furgoneta(id, matricula, capacidadCarga));
                        System.out.println("\nFurgoneta con ID " + id + " registrada.");

                    }else{
                        System.out.println("\n[ERROR] -> La capacidad debe ser superior a 0.");
                        System.out.println("Registro cancelado.");
                    }
                    break;

                case 2:
                    System.out.println("\nDATOS FURGONETAS");
                    System.out.println("================");

                    if(ListaFurgonetas.isEmpty()){
                        System.out.println("\nLa lista de furgonetas está vacía.");

                    }else{
                        capacidadCargaTotal = 0;
                        mayorCapacidadCarga = -1;
                        Furgoneta furgonetaMasPesada = null;

                        for(Furgoneta Furgo : ListaFurgonetas){
                            System.out.println("ID: " + Furgo.getId() + " || Matrícula: " + Furgo.getMatricula() + " || Capacidad de carga: " + Furgo.getCapacidadCarga() + " kg");

                            capacidadCargaTotal += Furgo.getCapacidadCarga();

                            if(Furgo.getCapacidadCarga() > mayorCapacidadCarga){
                                mayorCapacidadCarga = Furgo.getCapacidadCarga();
                                furgonetaMasPesada = Furgo;
                            }
                        }

                        totalFurgonetas = ListaFurgonetas.size();

                        System.out.println("\n- TOTAL DE FURGONETAS: " + totalFurgonetas);
                        System.out.println("- CAPACIDAD CARGA TOTAL: " + capacidadCargaTotal);
                        if (furgonetaMasPesada != null) {
                            System.out.println("- FURGONETA CON MAYOR CAPACIDAD: ID " + furgonetaMasPesada.getId() + " || Matrícula: " + furgonetaMasPesada.getMatricula() + " || Capacidad de carga: " + furgonetaMasPesada.getCapacidadCarga() + " kg");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Introduce el ID de al furgoneta que quieres buscar: ");
                    idBusqueda = sc.nextInt();

                    Furgoneta furgonetaEncontrada = null;

                    for(Furgoneta Furgo : ListaFurgonetas){

                        if (idBusqueda == Furgo.getId()){
                            furgonetaEncontrada = Furgo;
                        }
                    }

                    if (furgonetaEncontrada != null){
                        System.out.println("\nDATOS DE LA FURGONETA ENCONTRADA:");
                        System.out.println("- ID: " + furgonetaEncontrada.getId());
                        System.out.println(" - Matrícula: " + furgonetaEncontrada.getMatricula());
                        System.out.println(" - Capacidad de carga: " + furgonetaEncontrada.getCapacidadCarga() + " kg");

                    }else{
                        System.out.println("\n[ERROR] -> Furgoneta no encontrada.");
                    }
                    break;

                case 4:
                    System.out.println("Guardando datos en el disco duro antes de salir...");
                    guardarFichero(ListaFurgonetas);
                    System.out.println("Aplicación cerrada.");
                    break;

                default:
                    System.out.println("\"[ERROR] -> Opción inválida del menú.");
                    break;
            }

        }while(opcion != 4);

        sc.close();
    }

    public static boolean capacidadValida(double capacidadCarga){
        return capacidadCarga > 0;
    }

    public static void guardarFichero(ArrayList<Furgoneta> ListaFurgonetas){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("flota.dat"))){
            oos.writeObject(ListaFurgonetas);
            System.out.println("[SISTEMA] -> Datos serializados y guardados con éxito en 'flota.dat'.");

        } catch (IOException e) {
            System.out.println("[ERROR] -> No se pudo guardar el archivo " + e.getMessage());
        }
    }

    public static ArrayList<Furgoneta> cargarFichero(){
        ArrayList<Furgoneta> Lista = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("flota.dat"))){
            Lista = (ArrayList<Furgoneta>) ois.readObject();

        }catch (FileNotFoundException e){
            System.out.println("[SISTEMA] -> No hay datos previos. Iniciando una lista nueva.");

        }catch(ClassNotFoundException e) {
            System.out.println("[ERROR] -> No se encontró la clase para los objetos." + e.getMessage());

        } catch (IOException e) {
            System.out.println("[ERROR] -> Error al leer el archivo " + e.getMessage());
        }

        return Lista;
    }
}

class Furgoneta implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String matricula;
    private double capacidadCarga;

    public Furgoneta(int id, String matricula, double capacidadCarga){
        this.id = id;
        this.matricula = matricula;
        this.capacidadCarga = capacidadCarga;
    }

    public void setId(int id) {this.id = id;}

    public int getId() {return id;}

    public void setMatricula(String matricula){this.matricula = matricula;}

    public String getMatricula() {return matricula;}

    public void setCapacidadCarga(double capacidadCarga){ this.capacidadCarga = capacidadCarga; }

    public double getCapacidadCarga(){return capacidadCarga;}
}