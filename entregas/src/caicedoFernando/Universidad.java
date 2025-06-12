package caicedoFernando;

public class Universidad {
    protected String nombre;
    private Profesor profesorAsignatura;
    private Profesor profesorVigilante;
    private Asignatura asignatura;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void iniciar() {
        this.profesorAsignatura = new Profesor(
                "Ibuprofeno Jesus Fernández de la Piedra y Casado",
                "24445555X");

        this.profesorVigilante = new Profesor(
                "Dalsy Piedad de los Remedios Albornoz del Campo",
                "66645665X");

        this.asignatura = new Asignatura("Programación II", profesorAsignatura);

        imprimirDatos();

        coordinarExamen();

    }

    private void imprimirDatos() {
        System.out.println("Universidad: " + nombre);
        System.out.println(
                "Profesor: Profesor " + profesorAsignatura.getNombre() + " / DNI: " + profesorAsignatura.getDni());
        System.out.println("Asignatura: " + asignatura.getNombre());
        System.out.println("Examen: Examen Final");
        System.out.println("Vigilado por: " + profesorVigilante.getNombre() + " / DNI: " + profesorVigilante.getDni());

        Examen examen = profesorAsignatura.crearExamen();
        examen.imprimirPreguntas();

    }

    public void coordinarExamen() {
        if (profesorAsignatura.getDni().equals(profesorVigilante.getDni())) {
            System.out.println("El profesor que vigila no puede ser el mismo que el que imparte la asignatura.");
            return;
        }
    }

    public String getNombre() {
        return nombre;
    }
}