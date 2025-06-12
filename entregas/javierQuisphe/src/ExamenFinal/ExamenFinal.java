import java.util.ArrayList;
import java.util.List;

public class ExamenFinal {

    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlantico");

        Profesor prof1 = uni.crearProfesor("Julián Alvarez");
        Profesor prof2 = uni.crearProfesor("Emiliano Martinez");

        Asignatura mate = uni.crearAsignatura("Programación 2 - PRG2 - 6 Créditos");

        prof1.asignarAsignatura(mate);

        Examen examen = prof1.crearExamen(prof2);

        if (examen != null) {
            // Agregar 3 preguntas al examen
            examen.agregarPregunta(new Pregunta("¿Qué es la programación orientada a objetos?"));
            examen.agregarPregunta(new Pregunta("Explica la diferencia entre una clase y un objeto."));
            examen.agregarPregunta(new Pregunta("¿Qué son los modificadores de acceso en Java?"));

            System.out.println("\n--- Detalles del Examen ---");
            examen.mostrarInfo();
        }
    }
}

class Asignatura {
    String nombre;

    public Asignatura(String nombre) {
        this.nombre = nombre;
    }
}

class Pregunta {
    String texto;

    public Pregunta(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}

class Examen {
    Asignatura asignatura;
    Profesor creador;
    Profesor vigilante;
    List<Pregunta> preguntas = new ArrayList<>();

    public Examen(Asignatura asignatura, Profesor creador, Profesor vigilante) {
        this.asignatura = asignatura;
        this.creador = creador;
        this.vigilante = vigilante;
    }

    public void agregarPregunta(Pregunta pregunta) {
        preguntas.add(pregunta);
    }

    public void mostrarInfo() {
        System.out.println("Profesor: " + creador.getNombre());
        System.out.println("Asignatura: " + asignatura.nombre);
        System.out.println("Vigilado por: " + vigilante.getNombre());
        System.out.println("Preguntas del examen:");
        for (int i = 0; i < preguntas.size(); i++) {
            System.out.println((i + 1) + ". " + preguntas.get(i).getTexto());
        }
    }
}

class Profesor {
    private String nombre;
    private Asignatura asignatura;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean tieneAsignatura() {
        return asignatura != null;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        System.out.println(nombre + " imparte la asignatura de: " + asignatura.nombre);
    }

    public Examen crearExamen(Profesor vigilante) {
        if (!this.tieneAsignatura()) {
            System.out.println(nombre + " no puede crear examen, no tiene asignatura asignada");
            return null;
        }

        if (vigilante.tieneAsignatura()) {
            System.out.println(vigilante.getNombre() + " no puede vigilar el examen, ya tiene asignatura asignada");
            return null;
        }

        Examen examen = new Examen(this.asignatura, this, vigilante);
        System.out.println(nombre + " ha creado un examen de " + asignatura.nombre + " y lo entregó a " + vigilante.getNombre() + " para vigilar");
        return examen;
    }
}

class Universidad {
    private String nombre;
    private List<Profesor> profesores = new ArrayList<>();
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public Profesor crearProfesor(String nombre) {
        Profesor p = new Profesor(nombre);
        profesores.add(p);
        System.out.println("Profesor creado: " + nombre);
        return p;
    }

    public Asignatura crearAsignatura(String nombre) {
        Asignatura a = new Asignatura(nombre);
        asignaturas.add(a);
        System.out.println("Asignatura creada: " + nombre);
        return a;
    }
}
