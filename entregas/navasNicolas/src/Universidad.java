import java.util.ArrayList;
import java.util.List;

public class Universidad {
    String nombre;
    List<Profesor> profes = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String crearAsignatura(String nombreMat) {
        System.out.println("Asignatura creada: " + nombreMat);
        return nombreMat;
    }

    public Profesor contratarProfesor(String nombre) {
        Profesor profesor = new Profesor(nombre);
        profes.add(profesor);
        System.out.println("Profesor contratado: " + nombre);
        return profesor;
    }

    public void asignarAsignatura(Profesor profesor, String mat) {
        profesor.asignatura = mat;
        System.out.println("Asignatura " + mat +
                           " asignada a " + profesor.nombre);
    }

    public Examen comunicarExamen(Profesor profesor) {
        System.out.println(profesor.nombre + " recibe encargue de crear examen.");
        return profesor.crearExamen();
    }

    public void vigilarExamen(Profesor vigilante, Examen examen) {
        System.out.println(vigilante.nombre +
                           " (sin materia) vigila el examen de " +
                           examen.materia);
        vigilante.supervisarExamen(examen);
    }

    public void evaluarResultados(Examen examen) {
        examen.evaluar();
    }
}
