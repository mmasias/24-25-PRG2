public class ExamenFinal {
    public static void main(String[] args) {

        
        Universidad asignatura = Universidad.crearAsignatura("Progra II");

        Profesor profesor = Universidad.crearProfesor("Ibuprofeno Fernandez", "244455555X");
        profesor.asignarAsignatura(asignatura);

        CrearExamen examen = CrearExamen.contenidoExamen(
            "vista publica de clases",
            "vista publica de objetos",
            "vista privada de clases"
        );

       
        ProfesorVigilante vigilante = ProfesorVigilante.vigilarExamen("Manuel Masias", "111222333X");

        Mostrar.mostrarEscenario("Universidad Europea del Atlantico", profesor, asignatura, examen, vigilante);
    }
}
