import java.util.ArrayList;
import java.util.List;

public class SecretariaAcademica {
    String nombre;
    List<Profesor> profes = new ArrayList<>();

    public SecretariaAcademica(String nombre) {
        this.nombre = nombre;
    }

    public String crearAsignatura(String nombreMat) {
        System.out.println("Asignatura creada: " + nombreMat);
        return nombreMat;
    }

    public Profesor contratarProfesor(String nombre) {
        Profesor p = new Profesor(nombre);
        profes.add(p);
        System.out.println("Profesor contratado: " + nombre);
        return p;
    }

    public void asignarAsignatura(Profesor p, String mat) {
        p.asignatura = mat;
        System.out.println("Asignatura " + mat +
                           " asignada a " + p.nombre);
    }

    public Examen comunicarExamen(Profesor p) {
        System.out.println(p.nombre + " recibe encargue de crear examen.");
        return p.crearExamen();
    }

    public void vigilarExamen(Profesor vigilante, Examen e) {
        System.out.println(vigilante.nombre +
                           " (sin materia) vigila el examen de " +
                           e.materia);
        vigilante.supervisarExamen(e);
    }

    public void evaluarResultados(Examen e) {
        e.evaluar();
    }
}
