public class Profesor {
    private String nombre;
    private String asignatura;

    public Profesor(String nombre) {
        this.nombre = nombre;
        this.asignatura = null;
    }

    public void asignarAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean tieneAsignatura() {
        return asignatura != null;
    }

    public void crearExamen(Examen examen) {
        if (tieneAsignatura() && asignatura.toLowerCase().equals("programacion")) {
            System.out.println(nombre + " (Profesor 1, profesor de Programacion) ha creado un examen con 3 preguntas.");
            examen.agregarPregunta("1. ¿Qué es una variable?");
            examen.agregarPregunta("2. ¿Qué es una clase en Java?");
            examen.agregarPregunta("3. ¿Qué es la herencia?");
        } else {
            System.out.println(nombre + " (Profesor 2, sin asignatura) no puede crear el examen, solo puede vigilar.");
        }
    }

    public void entregar() {
        if (tieneAsignatura() && asignatura.toLowerCase().equals("programacion")) {
            System.out.println(nombre + " (Profesor 1, profesor de Programacion) ha entregado el examen.");
        } else {
            System.out.println(nombre + " (Profesor 2, sin asignatura) no puede entregar el examen, solo puede vigilar.");
        }
    }

    public void vigilar() {
        System.out.println(nombre + " está vigilando el examen.");
    }
}
