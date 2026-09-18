public class Main {
    public static void main (String[] args){

        CentroMedico centroMedico = new CentroMedico();

        centroMedico.procesarFicheroHistorial("urgencias.txt");

        centroMedico.mostrarPacientesUrgentesOrdenados();
    }
}
