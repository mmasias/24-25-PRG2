public class Profesores {
    private String nombre;
    private String dni;

    private Profesores(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public static Profesores crearProfesorParaExamen() {
        return new Profesores("Darwin Raglan Caspian Ahab Poseidon Nicodemus Watterson III", "P4445555E");
    }

    public static Profesores crearProfesorVigilante() {
        return new Profesores("Pelay Tistedal de los Remedios Albornoz del Campo", "66464646Y");
    }

    public Examen crearExamen() {
        return Examen.crearExamenFinalDeProgramacion();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }
}