public class Producto {
    private String idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;

    public Producto(String idProducto, String nombre, double precio, int stock, String categoria){
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    public String getIdProducto() {return idProducto;}
    public String getNombre() {return nombre;}
    public double getPrecio() {return precio;}
    public int getStock() {return stock;}
    public String getCategoria() {return categoria;}
    public void setIdProducto(String idProducto) {this.idProducto = idProducto;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setPrecio(double precio) {this.precio = precio;}
    public void setStock(int stock) {this.stock = stock;}
    public void setCategoria(String categoria) {this.categoria = categoria;}

    @Override
    public String toString(){
        return "ID: " + getIdProducto() + " | Nombre: " + getNombre() + " | Precio: " + getPrecio() + " | Stock: " + getStock() + " | Categoría: " + getCategoria();    }
}
