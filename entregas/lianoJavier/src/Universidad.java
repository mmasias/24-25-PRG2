
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
        mensaje("Universidad: ");
        mostrarNombre();
        saltarLinea();

        mensaje("Profesor: ");
        profesores[0].mostrarNombre();
        saltarLinea();

        mensaje("Asignatura: ");
        asignaturas[0].mostrarNombre();
        saltarLinea();

        mensaje("Examen: ");
        profesores[1].getExamen().mostrarNombre();
        saltarLinea();

        mensaje("Vigilado por: ");
        profesores[1].mostrarNombre();
        saltarLinea();

        profesores[1].getExamen().mostrarPreguntas();
    }

    private void saltarLinea() {
        System.out.println();
    }

    private void mostrarNombre() {
        mensaje(nombre);
    }

    private void mensaje(String string) {
        System.out.print(string);
    }

}
