package entregas.uretaAaron;

public class Universidad {

    private String nombre;
    private Profesor profesor;
    private Asignatura asignatura;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void contratarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        if (profesor != null) {
            profesor.asignarAsignatura(asignatura);
        }
    }

    public void imprimirInformacion() {
        System.out.println("UNIVERSIDAD: " + nombre);
        if (profesor != null) {
            profesor.imprimirInformacion();
        }
    }
}