import java.io.*;

public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    // Redefinimos el método para que NO vuelva a escribir la cabecera
    @Override
    protected void writeStreamHeader() throws IOException {
        // Se deja en blanco a propósito
    }
}
