import java.util.*;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Asignatura> asignaturas;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.asignaturas = new ArrayList<>();
    }

    public Asignatura crearAsignatura(String nombre) {
        Asignatura asignatura = new Asignatura(nombre);
        asignaturas.add(asignatura);
        return asignatura;
    }

    public Profesor contratarProfesor(String nombre) {
        Profesor profesor = new Profesor(nombre);
        profesores.add(profesor);
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }
}

public class Asignatura {
    private String nombre;
    private Profesor profesor;
    private Examen examen;

    public Asignatura(String nombre) {
        this.nombre = nombre;
        this.profesor = null;
        this.examen = null;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void asignarExamen(Examen examen) {
        this.examen = examen;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Examen getExamen() {
        return examen;
    }
}


