package valdesCarlos;

public class Sistema {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("UNEATLANTICO");

        Asignatura asignatura = universidad.crearAsignatura("Programación 2", 6);
        Profesor profesor = universidad.contratarProfesor("Ibuprofeno Jesús", "12345678X");
        ProfesorVigilante vigilante = new ProfesorVigilante("Dalsy Piedra", "87654321X");
        Alumno alumno = new Alumno("Carlos");

        universidad.asignarAsignatura(profesor, asignatura);
        universidad.iniciarExamen(profesor, vigilante, alumno);
    }
}
