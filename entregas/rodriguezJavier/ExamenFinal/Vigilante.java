public class Vigilante extends Profesores {
    private Examen examen;

    public Vigilante(String nombre, String dni) {
        super(nombre, dni);
    }

    public void recibirExamen(Examen examen) {
        this.examen = examen;
    }

    public Examen getExamen() {
        return examen;
    }
}