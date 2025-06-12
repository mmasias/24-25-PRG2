public class Sistema {
    public static void main(String[] args) {
        Universidad u = new Universidad("UNEATLANTICO");

        Asignatura a = u.crearAsignatura("Programación 2", 6);
        Profesor p = u.contratarProfesor("Ibuprofeno Jesús", "12345678X");
        ProfesorVigilante v = new ProfesorVigilante("Dalsy Piedra", "87654321X");
        Alumno alumno = new Alumno("Carlos");

        u.asignarAsignatura(p, a);
        u.iniciarExamen(p, v, alumno);
    }
}
