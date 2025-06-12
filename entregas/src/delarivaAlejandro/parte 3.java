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

import java.util.*;

public class Profesor {
    private String nombre;
    private Asignatura asignatura;
    private List<Examen> examenesVigilados;

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.asignatura = null;
        this.examenesVigilados = new ArrayList<>();
    }

    public void impartirAsignatura(Asignatura asignatura) {
        if (this.asignatura != null) {
            throw new IllegalStateException("Ya imparte una asignatura");
        }
        this.asignatura = asignatura;
        asignatura.asignarProfesor(this);
    }

    public Examen crearExamen() {
        if (asignatura == null) {
            throw new IllegalStateException("No imparte ninguna asignatura");
        }
        List<String> preguntas = Arrays.asList(
            "Pregunta 1: ¿Qué es una clase?",
            "Pregunta 2: Explique herencia en POO.",
            "Pregunta 3: ¿Qué es encapsulamiento?"
        );
        Examen examen = new Examen(asignatura, preguntas);
        asignatura.asignarExamen(examen);
        return examen;
    }

    public void vigilarExamen(Examen examen) {
        if (this.asignatura != null) {
            throw new IllegalStateException("No puede vigilar si imparte una asignatura");
        }
        this.examenesVigilados.add(examen);
        examen.asignarVigilante(this);
    }

    public void entregarExamenA(Examen examen, Profesor vigilante) {
        if (this.asignatura == null || examen.getAsignatura() != this.asignatura) {
            throw new IllegalStateException("No puede entregar examen que no es suyo");
        }
        vigilante.vigilarExamen(examen);
    }

    public String getNombre() {
        return nombre;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public List<Examen> getExamenesVigilados() {
        return examenesVigilados;
    }
}

import java.util.*;

public class Examen {
    private Asignatura asignatura;
    private List<String> preguntas;
    private Profesor vigilante;

    public Examen(Asignatura asignatura, List<String> preguntas) {
        this.asignatura = asignatura;
        this.preguntas = preguntas;
        this.vigilante = null;
    }

    public void asignarVigilante(Profesor vigilante) {
        this.vigilante = vigilante;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public Profesor getVigilante() {
        return vigilante;
    }
}

