public class ConversionTipos {
    public static void main (String[] args){
        double precioOriginal = 49.99;
        String textoNumero = "25";
        int cantidad;

        int precioEntero = (int)precioOriginal;
        cantidad = Integer.parseInt(textoNumero);

        cantidad = cantidad * 2;

        System.out.println("\nPrecio entero = " + precioEntero);

        System.out.println("\nVariable cantidad = " + cantidad);
    }
}
