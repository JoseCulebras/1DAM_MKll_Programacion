import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EjercicioPrueba_CalculadoraTest {

    @Test
    void test(){
        EjercicioPrueba_Calculadora calculadora = new EjercicioPrueba_Calculadora(2, 3);

        int resultado = calculadora.sumar(2,3);

        assertEquals(5,resultado);
    }
}