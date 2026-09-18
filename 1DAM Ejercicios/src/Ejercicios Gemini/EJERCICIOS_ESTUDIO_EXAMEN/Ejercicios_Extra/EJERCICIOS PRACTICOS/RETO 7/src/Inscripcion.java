public class Inscripcion {
    private String idInscripcion;
    private String nombreEstudiante;
    private String curso;
    private double precioPagado;
    private boolean completado;

    public Inscripcion(String idInscripcion, String nombreEstudiante, String curso, double precioPagado, boolean completado){
        this.idInscripcion = idInscripcion;
        this.nombreEstudiante = nombreEstudiante;
        this.curso = curso;
        this.precioPagado = precioPagado;
        this.completado = completado;
    }

    public String getIdInscripcion() {return idInscripcion;}
    public String getNombreEstudiante() {return nombreEstudiante;}
    public String getCurso() {return curso;}
    public double getPrecioPagado() {return precioPagado;}
    public boolean isCompletado() {return completado;}
    public void setIdInscripcion(String idInscripcion) {this.idInscripcion = idInscripcion;}
    public void setNombreEstudiante(String nombreEstudiante) {this.nombreEstudiante = nombreEstudiante;}
    public void setCurso(String curso) {this.curso = curso;}
    public void setPrecioPagado(double precioPagado) {this.precioPagado = precioPagado;}

    @Override
    public String toString(){
        return "ID: " + getIdInscripcion() + " | Curso: " + getCurso() + " | Nombre: " + getNombreEstudiante() + " | Precio pagado: " + getPrecioPagado() + " | Completado: " + completado;
    }

}
