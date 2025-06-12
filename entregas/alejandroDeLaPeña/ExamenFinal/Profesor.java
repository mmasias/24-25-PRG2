package entregas.alejandroDeLaPeña.ExamenFinal;

public class Profesor {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;

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

   
    public boolean entregarExamenA(Profesor vigilante, Asignatura[] asignaturas) {
        for (Asignatura a : asignaturas) {
            if (a != null && a.imparteProfesor(vigilante)) {
               
                return false;
            }
        }
        return true;
    }
}
