// Excepción propia que hereda de Exception (Checked Exception)
public class SalarioInvalidoException extends Exception {
    private static final long serialVersionUID = 1L;

    public SalarioInvalidoException(String mensaje) {
        super(mensaje);
    }
}