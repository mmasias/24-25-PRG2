package entregas.larinAlejandro;

public class App {
    public static void main(String[] args) {
      Universidad universidad = new Universidad("Universidad Europea del Atlántico");
      String asignatura = universidad.crearAsignatura("Programación 2 - PRG2", 6);
      
      Profesor profesor = universidad.contratarProfesor("Ibuprofeno del Jesus Fernandes Gomez de la piedra y Cansado","244455555");
      universidad.asignarProfesor(asignatura, profesor);
      profesor.crearExamen(asignatura);

      Profesor profesorVigia = universidad.contratarProfesor("Dalsy Piedad de los REmedios Albornoz del Campo","6646665");
      profesor.entregarExamen(profesorVigia);

      universidad.mostrarEsenario();
    }
}