public class Main {
    public static void main (String[] args){
        Gimnasio gimnasio = new Gimnasio();

        // Creamos varios socios para la modalidad de FUERZA (algunos menores, diferentes pesos)
        Socio s1 = new Socio("S01", "Carlos", 25, 85.4, "FUERZA");
        Socio s2 = new Socio("S02", "Ana", 17, 62.0, "FUERZA"); // Menor de edad (no debería listarse)
        Socio s3 = new Socio("S03", "David", 31, 71.5, "FUERZA"); // Pesa menos que Carlos
        Socio s4 = new Socio("S04", "Elena", 22, 68.2, "FUERZA");

        // Socios para otras modalidades
        Socio s5 = new Socio("S05", "Marcos", 45, 93.0, "CARDIO");

        Socio s6 = new Socio("S06", "Lucía", 20, 58.5, "PISCINA");

        gimnasio.inscribirSocio(s1);
        gimnasio.inscribirSocio(s2);
        gimnasio.inscribirSocio(s3);
        gimnasio.inscribirSocio(s4);
        gimnasio.inscribirSocio(s5);
        gimnasio.inscribirSocio(s6);

        // PRUEBA 1: Mostrar los de FUERZA ordenados por peso (Ana no debe salir, y David debe salir antes que Carlos)
        gimnasio.mostrarSociosPorModalidadOrdenados("FUERZA");

        // PRUEBA 2: Mostrar una modalidad vacía o que no existe
        gimnasio.mostrarSociosPorModalidadOrdenados("YOGA");

        // PRUEBA 3: Generar las métricas de rendimiento globales
        gimnasio.obtenerInformeEstadistico();
    }
}
