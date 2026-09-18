import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlmacenApp {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int opcion;
        double valorTotalComponente;
        double sumaValoresTotalesComponenetes;
        int id;
        int nuevaCantidad;

        ArrayList<Componente> listaComponentes = cargarInventarioInicial();

        do{
            System.out.println("=== CONTROL DE STOCK - ALMACÉN ===");
            System.out.println("1. Ver inventario completo y valor total");
            System.out.println("2. Modificar cantidad de un componente (Actualizar Stock)");
            System.out.println("3. Alerta de reposición (Exportar a Texto y Binario)");
            System.out.println("4. Salir");

            System.out.println("\nIntroduce la opción que desees: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("DATOS DE COMPONENTES");
                    System.out.println("====================");

                    if(listaComponentes.isEmpty()){
                        System.out.println("\nLa lista de componentes está vacía.");

                    }else{

                        sumaValoresTotalesComponenetes = 0;

                        for(Componente componente : listaComponentes){
                            System.out.println("ID: " + componente.getId() + " | Nombre del componente: " + componente.getNombre() + " | Cantidad: " + componente.getCantidad() + " | Precio: " + componente.getPrecio());

                            valorTotalComponente = componente.getCantidad() * componente.getPrecio();

                            sumaValoresTotalesComponenetes += valorTotalComponente;
                        }

                        double sumaFormateada = Double.parseDouble(String.format("%.2f", sumaValoresTotalesComponenetes));

                        System.out.println("\nVALOR TOTAL DEL ALMACÉN: " +  sumaFormateada);
                    }
                    break;

                case 2:
                    System.out.println("Introduce el ID del componente que deseas modificar: ");
                    id = sc.nextInt();

                    Componente componenteEncontrado = null;

                    for(Componente componente : listaComponentes){
                        if(id == componente.getId()){
                            componenteEncontrado = componente;
                            break;
                        }
                    }

                    if(componenteEncontrado != null){
                        System.out.println("\nIntroduce la nueva cantidad del componente: ");
                        do{
                            nuevaCantidad = sc.nextInt();

                            if(cantidadValida(nuevaCantidad)){
                                componenteEncontrado.setCantidad(nuevaCantidad);

                            }else{
                                System.out.println("\nIntroduce una nueva cantidad válida porfavor (mayor o igual a 0).");
                                System.out.println("Inténtalo de nuevo: ");
                            }
                        }while(!cantidadValida(nuevaCantidad));

                    }else{
                        System.out.println("\n[ERROR] Componente no encontrado.");
                    }
                    break;

                case 3:
                    exportarPedidos(listaComponentes);

                    guardarArchivoSeguridad(listaComponentes);
                    break;

                case 4:
                    System.out.println("\nCerrando el programa...");
                    break;

                default:
                    System.out.println("Opción no válida, inténtalo de nuevo: ");
                    break;
            }

        }while(opcion != 4);
        sc.close();
    }

    public static boolean cantidadValida(int cantidad){
        return cantidad >= 0;
    }

    public static ArrayList<Componente> cargarInventarioInicial(){

        ArrayList<Componente> listaCargada = new ArrayList<>();
        File fichero = new File("inventario_inicial.txt");

        if(!fichero.exists()){
            System.out.println("\nEl fichero 'inventario_inicial.txt' no se ha detectado");
            return listaCargada;
        }

        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
            String linea;

            while((linea = br.readLine()) != null){
                String[] datos = linea.split("#");

                if(datos.length == 4){
                    int id = Integer.parseInt(datos[0]);
                    String nombre = datos[1];
                    int cantidad = Integer.parseInt(datos[2]);
                    double precio = Double.parseDouble(datos[3]);

                    listaCargada.add(new Componente(id, nombre, cantidad, precio));
                }
            }

            System.out.println("\nDatos iniciales cargados desde 'inventario_inicial.txt' con éxito.");

        }catch (IOException e){
            System.out.println("\nNo se pudo leer el archivo de texto: " + e.getMessage());
        }

        return listaCargada;
    }

    public static void exportarPedidos(ArrayList<Componente> listaCompleta){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("pedidos.txt"))){

            listaCompleta.stream()
                    .filter(c -> c.getCantidad() < 10)
                    .forEach(c -> {
                        try{
                            bw.write("REPONER: " + c.getNombre() + "(Cantidad actual: " + c.getCantidad() + " unidades)");
                            bw.newLine();

                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    });
        }catch (IOException e){
            System.out.println("\nError al generar el fichero de pedidos.");
        }
    }

    public static void guardarArchivoSeguridad(ArrayList<Componente> listaComponentes){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("seguridad.dat"))){
            oos.writeObject(listaComponentes);
            System.out.println("\nArchivo 'seguridad.dat' guardado con éxito.");

        }catch (IOException e){
            System.out.println("\nNo se pudo guardar el archivo " + e.getMessage());
        }
    }
}

class Componente implements Serializable {
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;

    public Componente(int id, String nombre, int cantidad, double precio){
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public void setId(int id){this.id = id;}
    public int getId(){return id;}
    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return nombre;}
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
    public int getCantidad(){return cantidad;}
    public void setPrecio(int precio){this.precio = precio;}
    public double getPrecio(){return precio;}

    @Override
    public String toString(){return "ID: " +  id + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio;}
}