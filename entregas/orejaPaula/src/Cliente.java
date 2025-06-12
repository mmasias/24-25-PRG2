public class Cliente {
    public static void main(String[] args) {
        Universidad.crearAsignatura();
        Universidad.contratarProfesor();
        Asignatura.asignarAsignatura();
        Profesor.crearExamen();

        Universidad.ContratarOtroProfesor();
        Profesor.entregarExamen(Universidad.getOtroProfesor());

        Universidad.mostrar();
    }
}
