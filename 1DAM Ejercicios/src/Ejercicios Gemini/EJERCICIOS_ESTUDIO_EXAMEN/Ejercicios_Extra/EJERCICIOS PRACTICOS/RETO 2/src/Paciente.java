import java.util.Objects;

public class Paciente {
    private String sip;
    private String nombre;
    private int edad;
    private Prioridad prioridad;

    public Paciente(String sip, String nombre, int edad, Prioridad prioridad){
        this.sip = sip;
        this.nombre = nombre;
        this.edad = edad;
        this.prioridad = prioridad;
    }

    public String getSip() {return sip;}
    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public Prioridad getPrioridad() {return prioridad;}
    public void setSip(String sip) {this.sip = sip;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setEdad(int edad) {this.edad = edad;}
    public void setPrioridad(Prioridad prioridad) {this.prioridad = prioridad;}

    @Override
    public String toString(){
        return "SIP: " + sip + " | Nombre: " + nombre + " | Edad: " + edad + " | Prioridad: " + prioridad;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Paciente paciente = (Paciente) o;

        return Objects.equals(sip, paciente.sip);
    }

    @Override
    public int hashCode(){return Objects.hash(sip);}
}
