public class AmortizacionDePrestamo {
    public static void main (String[] args){

        double P = 6000;
        double A = 135;
        double interesAnual = 12;
        double deudaPendiente = P;
        double intereses;
        double cuotaMes;
        double amortizacion;
        double interesesAcumulados = 0;
        int mes = 1;

        //Introducción
        System.out.println("-----------------------------------------");
        System.out.println("Vamos a simular las cuotas de un préstamo");
        System.out.println("-----------------------------------------");

        System.out.print("\nEl importe adeudado inicial es: " + P + "\n");
        System.out.print("El interés es: " + interesAnual + "\n");

        while (deudaPendiente > 0){

            cuotaMes = A;

            //Calcular el interes del mes
            intereses = calcularInteresMes(deudaPendiente, interesAnual);

            //Comprobar si la deuda y los intereses del último mes es inferior a la cuota mensual
            if((deudaPendiente + intereses) < A){
                cuotaMes = deudaPendiente + intereses;
            }

            //Calcular la amortizacion (dinero que se le reduce de la deuda)
            amortizacion = calcularAmortizacion(cuotaMes, intereses, deudaPendiente);

            //Calcular los intereses acumulados y actualizar la deuda pendiente
            interesesAcumulados = redondear(interesesAcumulados + intereses);
            deudaPendiente = calcularDeudaPendiente(deudaPendiente, amortizacion);

            //Resultados
            mostrarResultadosMes(mes, intereses, amortizacion, interesesAcumulados, deudaPendiente);

            mes++;
        }
    }
    public static double calcularInteresMes(double deudaPendiente, double interesAnual){
        double interesMes = (((interesAnual/100)/365)*deudaPendiente) * 30;
        return redondear(interesMes);
    }

    public static double calcularAmortizacion(double cuota, double intereses, double deudaPendiente){
        double amortizacion = cuota - intereses;

        if (amortizacion > deudaPendiente){
            amortizacion = deudaPendiente;
        }

        return redondear(amortizacion);
    }

    public static double calcularDeudaPendiente(double deudaPendiente, double amortizacion){
        double deudaNueva = deudaPendiente - amortizacion;

        if (deudaNueva < 0){
            deudaNueva = 0;
        }

        return redondear(deudaNueva);
    }

    public static double redondear(double cantidad){
        return Math.round(cantidad * 100.0) / 100.0;
    }

    public static void mostrarResultadosMes(int mes, double intereses, double amortizacion, double interesesAcumulados, double deudaPendiente){
        System.out.println("- Cuota " + mes);
        System.out.println("    Interés de este mes " + intereses);
        System.out.println("    Amortización " + amortizacion);
        System.out.println("    Queda por pagar " + deudaPendiente + "\n");
    }
}
