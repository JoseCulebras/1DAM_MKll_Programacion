import java.util.ArrayList;

public class GestionarPedidos {
    private ArrayList<String> pedidos;

    public GestionarPedidos(){
        this.pedidos = new ArrayList<>();
    }

    public void anyadirPedido(String pedido){
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(String pedido){
        return pedidos.remove(pedido);
    }

    public boolean existePedido(String pedido){
        return pedidos.contains(pedido);
    }

    public int numeroPedidos(){
        return pedidos.size();
    }

    public ArrayList<String> obtenerListaPedidos(){
        return pedidos;
    }
}
