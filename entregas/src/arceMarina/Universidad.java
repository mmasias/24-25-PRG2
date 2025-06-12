package arceMarina;
public class Universidad {
    private Profesor[] profesores;
    private String[] asignaturas;
    private int numProfesores;
    private int numAsignaturas;
    private final String nombre;

    public Universidad() {
        this.profesores = new Profesor[10];
        this.asignaturas = new String[10];
        this.numProfesores = 0;
        this.numAsignaturas = 0;
        this.nombre = "Universidad Europea del Atlantico";

        inicializar();
    }

    private void inicializar() {
        Profesor profesor1 = new Profesor("Profesor X");
        Profesor profesor2 = new Profesor("Profesor Y");

        contratar(profesor1);
        contratar(profesor2);

        crearAsignatura("programación 2 - PRG2 - 6 creditos");
        asignarAsignatura(profesor1, "programación 2 - PRG2 - 6 creditos");

        profesor1.crearExamen();
        profesor1.entregarExamenA(profesor2);

        imprimirInformacion(profesor1, profesor2);
    }

    public void contratar(Profesor profesor) {
        if (hayEspacio(profesores, numProfesores)) {
            profesores[numProfesores++] = profesor;
        }
    }

    public void crearAsignatura(String asignatura) {
        if (hayEspacio(asignaturas, numAsignaturas)) {
            asignaturas[numAsignaturas++] = asignatura;
        }
    }

    public void asignarAsignatura(Profesor profesor, String asignatura) {
        if (existeAsignatura(asignatura)) {
            profesor.setAsignatura(asignatura);
            profesor.setProgramador(esAsignaturaDeProgramacion(asignatura));
        }
    }

    private boolean hayEspacio(Object[] arreglo, int cantidadActual) {
        return cantidadActual < arreglo.length;
    }

    private boolean existeAsignatura(String asignatura) {
        for (int i = 0; i < numAsignaturas; i++) {
            if (asignaturas[i].equalsIgnoreCase(asignatura)) {
                return true;
            }
        }
        return false;
    }

    private boolean esAsignaturaDeProgramacion(String asignatura) {
        return asignatura.toLowerCase().contains("programacion");
    }

    private void imprimirInformacion(Profesor profesor1, Profesor profesor2) {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor1.getNombre());
        System.out.println("Asignatura: " + profesor1.getAsignatura());

        Examen examen = profesor1.getExamen();
        if (examen != null) {
            System.out.println("Examen: " + examen.getTitulo());
            System.out.println("Vigilado por: " + profesor2.getNombre());

            for (int i = 0; i < examen.getPreguntas().length; i++) {
                System.out.println("Pregunta " + (i + 1) + ": \"" + examen.getPreguntas()[i] + "\"");
            }
        }
    }
}
