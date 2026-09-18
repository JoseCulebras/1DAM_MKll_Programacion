public class Ejercicio3_MediaArray {

    public double mediaArray(int[] array){

        int suma = 0;

        if (array == null || array.length == 0){
            return 0;
        }

        for (int i = 0; i < array.length; i++){
            suma += array[i];
        }

        return (double) suma / array.length;
    }
}
