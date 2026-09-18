import java.util.*;
import java.util.Map;

public class TiendaOnline {
    private Map<String, List<Producto>> inventario;

    public TiendaOnline(){
        this.inventario = new HashMap<>();
    }

    public void registrarProducto(Producto producto){
        inventario.computeIfAbsent(producto.getCategoria(), k -> new ArrayList<>()).add(producto);
    }

    public void buscarChollosPorCategoria(String categoria, double precioMaximo){
        List<Producto> productos = inventario.get(categoria);

        if(productos == null || productos.isEmpty()){
            System.out.println("\n[AVISO] No hay productos en la categoria: " + categoria);
        }

        System.out.println("\n=== PRODUCTOS EN STOCK ===");
        productos.stream()
                .filter(p -> p.getStock() > 0)
                .filter(p -> p.getPrecio() <= precioMaximo)
                .sorted(Comparator.comparingDouble(Producto :: getPrecio))
                .forEach(System.out::println);
    }

    public void mostrarValorTotalInventario(){
        if(inventario.isEmpty()){
            System.out.println("\n[AVISO] El inventario está vacío.");
            return;
        }

        System.out.println("\n=== VALOR TOTAL DEL INVENTARIO ===");
        inventario.forEach((categoria, listaProductos) ->{

            double valorTotalStock = listaProductos.stream()
                    .mapToDouble(p -> p.getPrecio() * p.getStock())
                    .sum();


            System.out.println("Categoría: " + categoria);
            System.out.println("  - Cantidad de productos: " + listaProductos.size());
            System.out.println("  - Valor total del stock: " + valorTotalStock + " €");
        });
    }
}
