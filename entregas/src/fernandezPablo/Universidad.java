package entregas.src.fernandezPablo;

public class Universidad {
    private Profesor[] profesores = new Profesor[2];
    private Examen examen;


    public void contratar() {
        profesores[0] = new Profesor("Profesor 1", true);  
        profesores[1] = new Profesor("Profesor 2", false); 
        System.out.println("Se han contratado 2 profesores.");
    }

    public void asignar() {
        profesores[0].asignar("Programación");
        System.out.println(profesores[0].getNombre() + " ha sido asignado a la asignatura de Programación.");
    }

    public void gestionarExamen() {
        examen = profesores[0].crearExamen();
        profesores[0].entregar(examen);
        profesores[1].vigilar(examen);
    }

    public static void main(String[] args) {
        Universidad uneatlantico = new Universidad();
        uneatlantico.contratar();
        uneatlantico.asignar();
        uneatlantico.gestionarExamen();
    }


}
