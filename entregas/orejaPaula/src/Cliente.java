public class Cliente {
    public static void main(String[] args) {
        Universidad.crearAsignatura();
        Universidad.contratarProfesor();
        Asignatura asignatura = Asignatura.asignarAsignatura();
        Profesor.crearExamen(asignatura);

        Universidad.ContratarOtroProfesor();
        // Simulamos que el segundo profesor NO tiene asignatura
        Profesor.entregarExamen(null);

        Universidad.mostrar();
    }
}

