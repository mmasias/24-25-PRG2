import java.util.*;

public class Universidad {
    private String nombre;
    private List<Asignatura> asignaturas = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Asignatura crearAsignatura(String nombreAsig) {
        Asignatura a = new Asignatura(nombreAsig);
        asignaturas.add(a);
        System.out.println("Asignatura creada: " + nombreAsig);
        return a;
    }

    public Profesor contratarProfesor(String nombreProf) {
        Profesor p = new Profesor(nombreProf);
        profesores.add(p);
        System.out.println("Profesor contratado: " + nombreProf);
        return p;
    }

    public void asignarAsignatura(Profesor p, Asignatura a) {
        p.setAsignatura(a);
        System.out.println("Asignatura " + a.getNombre() +
                           " asignada a " + p.getNombre());
    }

    public Examen comunicarExamen(Profesor p) {
        System.out.println(p.getNombre() + " recibe encargo de crear examen.");
        Examen e = p.crearExamen();
        return e;
    }

    public void vigilarExamen(Profesor vigilante, Examen e) {
        System.out.println(vigilante.getNombre() +
                           " (sin asignatura) vigila el examen de " +
                           e.getAsignatura().getNombre());
        vigilante.supervisarExamen(e);
    }

    public void evaluarResultados(Profesor p, Examen e) {
        System.out.println(p.getNombre() + " recibe examen de vuelta y evalúa:");
        p.evaluarExamen(e);
    }
}
