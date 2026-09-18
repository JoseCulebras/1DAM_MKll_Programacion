import java.util.Objects;

public class Pasajero {
    private String dni;
    private String nombre;
    private String asiento;

    public Pasajero(String dni, String nombre, String asiento){
        this.dni = dni;
        this.nombre = nombre;
        this.asiento = asiento;
    }

    public String getDni() {return dni;}
    public String getNombre() {return nombre;}
    public String getAsiento() {return asiento;}
    public void setDni(String dni) {this.dni = dni;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setAsiento(String asiento) {this.asiento = asiento;}

    @Override
    public String toString(){
        return "DNI: " + getDni() + " | Asiento: " + getAsiento() + " | Nombre: " + getNombre();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){return true;}

        if(o == null || getClass() != o.getClass()){return false;}

        Pasajero pasajero = (Pasajero) o;

        return Objects.equals(dni, pasajero.dni);
    }

    @Override
    public int hashCode(){return Objects.hash(dni);}
}