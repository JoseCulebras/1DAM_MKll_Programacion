import java.util.HashSet;
import java.util.Set;

public class Vuelo {
    private String codigoVuelo;
    private String destino;
    private Set<Pasajero> listaPasajeros;

    public Vuelo(String codigoVuelo, String destino){
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.listaPasajeros = new HashSet<>();
    }

    public String getCodigoVuelo() {return codigoVuelo;}
    public String getDestino() {return destino;}
    public void setCodigoVuelo(String codigoVuelo) {this.codigoVuelo = codigoVuelo;}
    public void setDestino(String destino) {this.destino = destino;}
    public Set<Pasajero> getListaPasajeros() {return listaPasajeros;}
}