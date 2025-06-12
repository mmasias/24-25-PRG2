
public class Universidad {

    private static final int CREDITOS_ASIGNATURA = 6;
    private Asignatura[] asignaturas;
    private Profesor[] profesores;

    private String nombre;

    public Universidad(String nombre) {
        this.nombre = nombre;

        asignaturas = new Asignatura[1];
        asignaturas[0] = new Asignatura("Programación 2", "PRG2", CREDITOS_ASIGNATURA);

        profesores = new Profesor[2];
        profesores[0] = new Profesor("Ibuprogeno del Jesús Fernandez Gómez de la Piedra Cansado", "244455555X");
        profesores[1] = new Profesor("Dalsy Piedad de los Remedios Albornoz del Campo", "666456665X");
    }

    public void abrir() {
        profesores[0].asignar(asignaturas[0]);
        profesores[0].crearExamen();
        profesores[0].darExamen(profesores[1]);
        mostrarEscenario();
    }

    private void mostrarEscenario() {
        mostarNombreUniversidad();
        Utilidades.saltarLinea();

        Utilidades.mensaje("Profesor: ");
        mostrarDatosProfesor(profesores[0]);
        Utilidades.saltarLinea();

        Utilidades.mensaje("Asignatura: ");
        asignaturas[0].mostrarNombre();
        Utilidades.saltarLinea();

        Utilidades.mensaje("Examen: ");
        profesores[1].getExamen().mostrarNombre();
        Utilidades.saltarLinea();

        Utilidades.mensaje("Vigilado por: ");
        mostrarDatosProfesor(profesores[1]);
        Utilidades.saltarLinea();

        profesores[1].getExamen().mostrarPreguntas();
    }

    private void mostrarDatosProfesor(Profesor profesor) {
        profesor.mostrarNombre();
        Utilidades.mensaje(" / ");
        Utilidades.mensaje("DNI ");
        profesor.mostrarDNI();
    }

    private void mostarNombreUniversidad() {
        Utilidades.mensaje("Universidad: ");
        mostrarNombre();
    }

    private void mostrarNombre() {
        Utilidades.mensaje(nombre);
    }

}
