package entregas.grizoniManuela;

import java.util.List;
import java.util.ArrayList;

public class Examen {
    private String        nombre;
    private Profesor      profesorVigilante;
    private List<Pregunta> preguntas;

    public Examen(String nombre, Profesor profesorVigilante) {
        this.nombre            = nombre;
        this.profesorVigilante = profesorVigilante;
        this.preguntas         = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesorVigilante() {
        return profesorVigilante;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesorVigilante(Profesor profesorVigilante) {
        this.profesorVigilante = profesorVigilante;
    }

    public void addPregunta(Pregunta p) {
        preguntas.add(p);
    }

    public void removePregunta(Pregunta p) {
        preguntas.remove(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Examen: ").append(nombre).append("\n")
          .append("       Vigilado por: ")
          .append(profesorVigilante.getNombre())
          .append(" / DNI ").append(profesorVigilante.getDni())
          .append("\n");
        for (int i = 0; i < preguntas.size(); i++) {
            sb.append("               Pregunta ")
              .append(i + 1)
              .append(": ").append(preguntas.get(i))
              .append("\n");
        }
        return sb.toString().trim();
    }
}
