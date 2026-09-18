public class Ejercicio5_InvertirString {

    public String invertirString(String i){

        if (i == null){
            return null;
        }

        return new StringBuilder(i).reverse().toString();
    }
}
