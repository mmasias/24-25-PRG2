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
        profesor1.entregar(profesor2);

        imprimirInformacion(profesor1);
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
            profesor.asignar(asignatura);
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

    private void imprimirInformacion(Profesor profesor) {
        System.out.println("Universidad: " + nombre);
        profesor.mostrarDatos();
    }
}
