public class Cliente {
    public static void main(String[] args) {
        Universidad.crearAsignatura();
        Universidad.contratarProfesor();
        Asignatura asignatura = Asignatura.asignarAsignatura();

        Profesor.crearExamen(asignatura);

        Universidad.ContratarOtroProfesor();
        Profesor.entregarExamen(null); 

        Universidad.mostrar();
    }
}

