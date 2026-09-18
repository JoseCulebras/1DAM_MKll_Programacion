public class Main {
    public static void main (String[] args){
        AcademiaOnline academia = new AcademiaOnline();

        Inscripcion i1 = new Inscripcion("I1", "Jose", "1ºDAM", 10, true);
        Inscripcion i2 = new Inscripcion("I2", "Pozo", "1ºDAM", 10, true);
        Inscripcion i3 = new Inscripcion("I3", "Maria", "1ºDAM", 10, false);
        Inscripcion i4 = new Inscripcion("I4", "Adrian", "1ºDAM", 10, true);
        Inscripcion i5 = new Inscripcion("I5", "Juan", "1ºDAM", 10, false);
        Inscripcion i6 = new Inscripcion("I6", "Cristian", "1ºDAM", 10, true);

        academia.registrarInscripcion(i1);
        academia.registrarInscripcion(i2);
        academia.registrarInscripcion(i3);
        academia.registrarInscripcion(i4);
        academia.registrarInscripcion(i5);
        academia.registrarInscripcion(i6);

        academia.obtenerInformePorCurso();
    }
}
