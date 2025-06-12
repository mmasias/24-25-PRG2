public class Vigilante extends Profesores {
    Examen examen;

    public Vigilante(String nombre, String dni) {
        super(nombre, dni);
    }

    public void recibirExamen(Examen examen) {
        this.examen = examen;
    }
}
