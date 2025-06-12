package src.gonzalezMarcos;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Examen crearExamen(String titulo) {
        Examen examen = new Examen(this.asignatura, titulo);
        examen.agregarPregunta("¿Qué es la programación orientada a objetos?");
        examen.agregarPregunta("Explique el concepto de herencia.");
        examen.agregarPregunta("¿Qué es el polimorfismo en Java?");
        return examen;
    }

    public void entregarExamenA(Examen examen, Profesor vigilante) {
        System.out.println(this.nombre + " ha entregado el examen a " + vigilante.getNombre());
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}

