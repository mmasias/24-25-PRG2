package entregas.src_GabrielBéjar;

public class Universidad {
    private String nombre;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    private Asignatura crearAsignatura(String nombreAsignatura, int creditos) {
        return new Asignatura(nombreAsignatura, creditos);
    }

    private ProfesorAsignatura contratarProfesorAsignatura(String nombre, String dni) {
        return new ProfesorAsignatura(nombre, dni);
    }

    private ProfesorVigila contratarProfesorVigila(String nombre, String dni) {
        return new ProfesorVigila(nombre, dni);
    }

    public void ejecutarEscenario() {
        Asignatura asignatura = crearAsignatura("Programación II", 6);
        ProfesorAsignatura profesorImparte = contratarProfesorAsignatura("Luis García", "12345678A");
        profesorImparte.asignarAsignatura(asignatura);
        Examen examen = profesorImparte.getExamen();

        ProfesorVigila profesorVigila = contratarProfesorVigila("Marta Pérez", "87654321B");
        profesorVigila.recibirExamen(examen);

        Alumno alumno = new Alumno("Carlos Ruiz");

        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesorImparte.getIdentificacion());
        System.out.println("Asignatura: " + asignatura.getInformacion());
        System.out.println("Examen: " + examen.getTitulo());
        System.out.println("Vigilado por: " + profesorVigila.getIdentificacion());

        String[] preguntas = examen.getPreguntas();
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + (i + 1) + ": \"" + preguntas[i] + "\"");
        }
    }
}
