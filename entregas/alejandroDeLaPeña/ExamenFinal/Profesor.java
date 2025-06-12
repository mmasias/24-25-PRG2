package entregas.alejandroDeLaPeña.ExamenFinal;

public class Profesor {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private Asignatura asignaturaImpartida;

    public Profesor(String nombre, String apellido1, String apellido2, String dni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido1 + " " + apellido2;
    }

    public String getDni() {
        return dni;
    }

    public void setAsignaturaImpartida(Asignatura asignatura) {
        this.asignaturaImpartida = asignatura;
    }

    public Asignatura getAsignaturaImpartida() {
        return asignaturaImpartida;
    }

    public boolean entregarExamenA(Profesor vigilante, Asignatura[] asignaturas) {
        for (Asignatura a : asignaturas) {
            if (a != null && a.imparteProfesor(vigilante)) {
                return false; // el vigilante imparte alguna asignatura
            }
        }
        return true;
    }

    public void mostrarProfesor() {
        System.out.print("Profesor: " + getNombreCompleto() + ", DNI: " + dni);
        if (asignaturaImpartida != null) {
            System.out.println(" | Imparte: " + asignaturaImpartida.getNombreAsignatura());
        } else {
            System.out.println(" | No imparte ninguna asignatura.");
        }
    }
}
