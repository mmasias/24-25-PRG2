public class Asignatura {
    private String nombre;
    private String examen;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.examen = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void crearExamen() {
        this.examen = "Examen final de " + nombre;
        System.out.println("Se ha creado el examen de la asignatura: " + nombre);
    }

    public String entregarExamen() {
        return examen;
    }

    public String entregarDatosAsignatura() {
        return "Asignatura: " + nombre;
    }
}
