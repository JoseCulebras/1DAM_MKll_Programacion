public class Main {
    public static void main (String[] args){

        Taller lineasDeTrabajo = new Taller();

        Coche c1 = new Coche("6739FNR", 5000);
        Coche c2 = new Coche("1234ABC", 1000);
        Coche c3 = new Coche("4321CBA", 2000);
        Coche c4 = new Coche("5678MNB", 4000);

        lineasDeTrabajo.registrarAverias(c1, "Radio no funcional");
        lineasDeTrabajo.registrarAverias(c2, "Rueda faltante", "Puerta faltante");
        lineasDeTrabajo.registrarAverias(c3, "Rueda superior derecha deshinchada");
        lineasDeTrabajo.registrarAverias(c4, "Retrovisor izquierdo faltante", "Retrovisor derecho faltante");

        lineasDeTrabajo.asignarLinea("Electrónica", c1);
        lineasDeTrabajo.asignarLinea("Mecánica", c2);
        lineasDeTrabajo.asignarLinea("Mecánica", c3);
        lineasDeTrabajo.asignarLinea("Mecánica", c4);

        lineasDeTrabajo.despacharLinea("Mecánica");
    }
}
