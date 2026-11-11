import java.util.Scanner;

public class RenovandoDNI {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        String dniDanyado;
        String patron;
        int posibilidadesDNI;
        String[] posibles_dni = new String[100];

        System.out.println("\nIntroduce un DNI con un máximo de 2 errores." + "\n(No pueden estar seguidos y tampoco al principio y antes de la letra): ");
        dniDanyado = sc.next().toUpperCase();

        System.out.println("\nIntroduce el patrón del error: ");
        patron = sc.next();

        posibilidadesDNI = repararDNI(dniDanyado, patron, posibles_dni);

        System.out.println("\nPosible/es reparación/es del DNI: ");
        for (int i = 0; i < posibilidadesDNI; i++){
            System.out.println(posibles_dni[i]);
        }
    }

    public static char calculaDNI(int dni){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        int restoDNI = dni % 23;

        return letras.charAt(restoDNI);
    }

    public static int repararDNI(String DNI, String patron, String[] posibles_dni){
        char letraDNI = DNI.charAt(DNI.length() - 1);
        String numerosDNI = DNI.substring(0, DNI.length() - 1);
        int contadorErrores = numerosDNI.length() - numerosDNI.replace(patron, "").length();
        int erroresEncontrados = 0;

        if (contadorErrores == 1){
            for (int i = 0; i <= 9; i++){
                String errorDNI = numerosDNI.replace(patron, String.valueOf(i));
                int valorReparado = Integer.parseInt(errorDNI);

                if (calculaDNI(valorReparado) == letraDNI){
                    posibles_dni[erroresEncontrados] = errorDNI + letraDNI;
                    erroresEncontrados++;
                }
            }

        }else if (contadorErrores == 2){
            for (int i = 0; i <= 9; i++){
                for (int j = 0; j <= 9; j++){
                    String errorDNI = numerosDNI.replaceFirst(patron, String.valueOf(i));
                    errorDNI = errorDNI.replaceFirst(patron, String.valueOf(j));
                    int valorReparado = Integer.parseInt(errorDNI);

                    if (calculaDNI(valorReparado) == letraDNI){
                        posibles_dni[erroresEncontrados] = errorDNI + letraDNI;
                        erroresEncontrados++;
                    }
                }
            }
        }

        return erroresEncontrados;
    }
}
