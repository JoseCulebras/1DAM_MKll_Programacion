public class TEST {
    public static void main(String[] args) {
        String entrada = "Jose Culebras";
        String regex = "^[a-zA-Z\\s]+$";

        if (entrada.matches(regex)){
            System.out.println("Nombre válido");
        }else{
            System.out.println("Nombre inválido");
        }

    }
}