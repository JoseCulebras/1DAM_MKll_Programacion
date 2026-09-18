public class Jugador {
    private String idJugador;
    private String nickname;
    private int puntosCompetitivos;
    private String rango;
    private String videojuego;

    public Jugador(String idJugador, String nickname, int puntosCompetitivos, String rango, String videojuego){
        this.idJugador = idJugador;
        this.nickname = nickname;
        this.puntosCompetitivos = puntosCompetitivos;
        this.rango = rango;
        this.videojuego = videojuego;
    }

    public String getIdJugador() {return idJugador;}
    public String getNickname() {return nickname;}
    public int getPuntosCompetitivos() {return puntosCompetitivos;}
    public String getRango() {return rango;}
    public String getVideojuego() {return videojuego;}
    public void setIdJugador(String idJugador) {this.idJugador = idJugador;}
    public void setNickname(String nickname) {this.nickname = this.nickname;}
    public void setPuntosCompetitivos(int puntosCompetitivos) {this.puntosCompetitivos = puntosCompetitivos;}
    public void setRango(String rango) {this.rango = rango;}
    public void setVideojuego(String videojuego) {this.videojuego = videojuego;}

    @Override
    public String toString(){
        return "ID: " + getIdJugador() + " | Nickname: " + getNickname() + " | Puntos Competitivos: " + getPuntosCompetitivos() + " | Rango: " + getRango() + " | Videojuego: " + getVideojuego();
    }
}
