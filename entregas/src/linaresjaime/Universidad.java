
public class Universidad {
    private String nombre;
    private Profesor[] profesores;
    private Asignatura[] asignaturas;
    private Vigilante[] vigilantes;
    private int numProfesores;
    private int numAsignaturas;
    private int numVigilantes;

    public Universidad(String nombre) {
        this.nombre = nombre;
        profesores = new Profesor[10];
        asignaturas = new Asignatura[10];
        vigilantes = new Vigilante[10];
        numProfesores = 0;
        numAsignaturas = 0;
        numVigilantes = 0;
    }

    public void crearAsignatura(String nombre, int creditos) {
        if (numAsignaturas < asignaturas.length) {
            asignaturas[numAsignaturas++] = new Asignatura(nombre, creditos);
        }
    }

    public void contratarProfesor(String nombre, String dni) {
        if (numProfesores < profesores.length) {
            profesores[numProfesores++] = new Profesor(nombre, dni);
        }
    }

    public void contratarVigilante(String nombre, String dni) {
        if (numVigilantes < vigilantes.length) {
            vigilantes[numVigilantes++] = new Vigilante(nombre, dni);
        }
    }

    public Profesor getProfesor(String dni) {
        for (int i = 0; i < numProfesores; i++) {
            if (profesores[i].getDni().equals(dni)) {
                return profesores[i];
            }
        }
        return null;
    }

    public Vigilante getVigilante(String dni) {
        for (int i = 0; i < numVigilantes; i++) {
            if (vigilantes[i].getDni().equals(dni)) {
                return vigilantes[i];
            }
        }
        return null;
    }

    public Asignatura getAsignatura(String nombre) {
        for (int i = 0; i < numAsignaturas; i++) {
            if (asignaturas[i].getNombre().equals(nombre)) {
                return asignaturas[i];
            }
        }
        return null;
    }
}
