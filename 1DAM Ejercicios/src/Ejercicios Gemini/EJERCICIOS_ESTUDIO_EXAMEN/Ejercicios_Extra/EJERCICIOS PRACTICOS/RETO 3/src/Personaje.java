import java.io.Serializable;

public abstract class Personaje implements Serializable, Atacante {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int nivel;
    private int puntosVida;

    public Personaje(String nombre, int nivel, int puntosVida){
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
    }

    public String getNombre() {return nombre;}
    public int getNivel() {return nivel;}
    public int getPuntosVida() {return puntosVida;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setNivel(int nivel) {this.nivel = nivel;}
    public void setPuntosVida(int puntosVida) {this.puntosVida = puntosVida;}

    public abstract void recibirDanio(int danio);

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + " | Nivel: " + getNivel() + " | Puntos de vida: " + getPuntosVida();
    }
}
