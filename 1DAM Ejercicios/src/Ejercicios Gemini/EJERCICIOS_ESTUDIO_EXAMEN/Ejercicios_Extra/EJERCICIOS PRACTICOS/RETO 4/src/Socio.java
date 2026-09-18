public class Socio {
    private String idSocio;
    private String nombre;
    private int edad;
    private double peso;
    private String modalidad;

    public Socio(String idSocio, String nombre, int edad, double peso, String modalidad){
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.modalidad = modalidad;
    }

    public String getIdSocio() {return idSocio;}
    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public double getPeso() {return peso;}
    public String getModalidad() {return modalidad;}
    public void setIdSocio(String idSocio) {this.idSocio = idSocio;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setPeso(double peso) {this.peso = peso;}
    public void setModalidad(String modalidad) {this.modalidad = modalidad;}

    @Override
    public String toString(){
        return "ID: " + getIdSocio() + " | Nombre: " + getNombre() + " | Edad: " + getEdad() + " | Peso: " + getPeso() + " | Modalidad: " + getModalidad();
    }
}