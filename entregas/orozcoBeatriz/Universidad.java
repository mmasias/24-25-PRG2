package entregas.orozcoBeatriz;

public class Universidad {

    private Asignatura[] asignaturas = new Asignatura[10];
    public Profesor[] profesores = new Profesor[10];
    private int totalAsignaturas = 0;
    private int totalProfesores = 0;
    private String nombre;

    public Universidad() {
        this.nombre = "Universidad Europea del Atlántico";
    }

    public void crearAsignatura() {
        if (totalAsignaturas < asignaturas.length) {
            asignaturas[totalAsignaturas] = new Asignatura("Asignatura" + (totalAsignaturas + 1));
            totalAsignaturas++;
        }
    }

    public void crearProfesor() {
        if (totalProfesores < profesores.length) {
            if (totalProfesores % 2 == 0) {
                profesores[totalProfesores] = new ProfesorImparte("Profesor" + (totalProfesores + 1));
            } else {
                profesores[totalProfesores] = new ProfesorVigila("Profesor" + (totalProfesores + 1));
            }
            totalProfesores++;
        }
    }

    public void asignarAsignatura() {
        if (totalAsignaturas < asignaturas.length) {
            asignaturas[totalAsignaturas] = new Asignatura("Asignatura" + (totalAsignaturas + 1));
            totalAsignaturas++;
        }
    }

    public void registrarProfesor() {
        if (totalProfesores < profesores.length) {
            profesores[totalProfesores] = new Profesor("Profesor" + (totalProfesores + 1));
            totalProfesores++;
        }
    }

    public void imprimirResumen() {
        System.out.println("\n-------------------------");
        System.out.println("Universidad: " + nombre);
        if (totalProfesores > 0) {
            System.out.println("Profesor: " + profesores[0].nombre);
        }
        if (totalAsignaturas > 0) {
            System.out.println("Asignatura: " + asignaturas[0].getNombre());
        }
        System.out.println("Examen: Registrado");
        System.out.println("Preguntas: 3");
        System.out.println("-------------------------\n");
    }

    public void ejecutarSimulacion() {
        crearProfesor();
        crearProfesor();
        crearAsignatura();

        ProfesorImparte imparte = (ProfesorImparte) profesores[0];
        ProfesorVigila vigila = (ProfesorVigila) profesores[1];

        imparte.crearExamenConPreguntas("Asignatura1");
        imparte.entregarExamenA(vigila);
        vigila.vigilarExamen();

        imprimirResumen();
    }
}

