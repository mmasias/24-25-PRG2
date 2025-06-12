public class Profesores {
    private String nombre_profesor;
    private String dni_profesor;

    private Profesores(String nombre_profesor, String dni_profesor) {
        this.nombre_profesor = nombre_profesor;
        this.dni_profesor = dni_profesor;
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

    public String getNombre_profesor() {
        return this.nombre_profesor;
    }

    public String getDni_profesor() {
        return this.dni_profesor;
    }
}