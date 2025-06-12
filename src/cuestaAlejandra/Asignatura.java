class Asignatura {
    private String nombre;
    private String codigo;
    private int creditos;
    private Profesor profesorAsignado;

    public Asignatura(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public void asignarAsignatura(Profesor profesor) {
        this.profesorAsignado = profesor;
        profesor.SetAsignatura(this);
    }

    public String obtenerDescripcion() {
        return "Asignatura: " + nombre + " - " + codigo + " - " + creditos + " créditos";
    }
}