public class Main {
    public static void main (String[] args){
        TiendaOnline tienda = new TiendaOnline();

        Producto p1 = new Producto("P01", "Ratón", 15, 10, "ELECTRONICA");
        Producto p2 = new Producto("P02", "Teclado", 45, 5, "ELECTRONICA");
        Producto p3 = new Producto("P03", "Monitor", 200, 0, "ELECTRONICA");

        tienda.registrarProducto(p1);
        tienda.registrarProducto(p2);
        tienda.registrarProducto(p3);

        tienda.buscarChollosPorCategoria("ELECTRONICA", 50);

        tienda.mostrarValorTotalInventario();
    }
}
