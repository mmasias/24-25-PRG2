package rubioRicardo;

import java.util.ArrayList;
import java.util.List;

public class Examen {
    private String nombre;
    private List<String> preguntas = new ArrayList<>();
    private Profesor creador;
    private Profesor vigilado;
    private Asignatura asignatura;

    public Examen(String nombre, Profesor creador, Asignatura asignatura) {
        this.nombre = nombre;
        this.creador = creador;
        this.asignatura = asignatura;
    }

    public void crearPreguntas() {
        preguntas.add("¿Qué es una derivada?");
        preguntas.add("Define el teorema fundamental del cálculo.");
        preguntas.add("¿Cuál es la integral de x^2?");
    }

    public static void iniciar(Universidad universidad) {
        universidad.imprimir();
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getPreguntas() {
        return preguntas;
    }

    public Profesor getCreador() {
        return creador;
    }

    public void setVigilado(Profesor p) {
        this.vigilado = p;
    }

    public Profesor getVigilado() {
        return vigilado;
    }
}

