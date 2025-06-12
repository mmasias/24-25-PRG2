package solarAdrian;


public class Universidad {
    private String nombre;
    private Asignatura asignatura;
    private Profesor profesor;
    private Supervisor supervisor;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void crearAsignatura(String nombre, String codigo, int creditos) {
        asignatura = new Asignatura(nombre, codigo, creditos);
    }

    public void contratarProfesor(String nombre, String dni) {
        profesor = new Profesor(nombre, dni);
    }

    public void contratarSupervisor(String nombre, String dni) {
        supervisor = new Supervisor(nombre, dni);
    }

    public void asignarAsignaturaAlProfesor() {
        profesor.asignarAsignatura(asignatura);
    }

    public void profesorCreaExamen() {
        profesor.crearExamen();
        examen = profesor.getExamenCreado();
    }

    public void entregarExamenAlSupervisor() {
        examen.asignarSupervisor(supervisor);
    }

    public void mostrarEscenarioCompleto() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor : " + profesor.getNombre());
        System.out.println("Asignatura: " + asignatura.getNombre() + " - " + asignatura.getCodigo() + " - " + asignatura.getCreditos() + " créditos");
        System.out.println("Examen: Examen Final");
        System.out.println("Vigilado por: " + supervisor.getNombre());
        System.out.println("Pregunta 1: \"Vista pública clases\"");
        System.out.println("Pregunta 2: \"Vista pública de objetos\"");
        System.out.println("Pregunta 3: \"Vista privada de clases\"");
       
    }
}
