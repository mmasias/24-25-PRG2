public class ProfesorVigilante extends Profesor {
    public ProfesorVigilante(String nombre, String dni) {
        super(nombre, dni);
    }

    @Override
    public String toString() {
        return "Profesor Vigilante: " + getNombre() + " / DNI: " + getDni();
    }
}
