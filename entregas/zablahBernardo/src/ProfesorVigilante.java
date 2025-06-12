public class ProfesorVigilante extends Profesor {
    private String examen;

    public ProfesorVigilante(String nombre, String dni) {
        super(nombre, dni);
    }

    public void recibirExamen(String examen) {
        this.examen = examen;
        System.out.println(nombre + " ha recibido el examen para vigilar.");
    }

    public void vigilarExamen() {
        if (examen != null) {
            System.out.println(nombre + " está vigilando el examen: " + examen);
        } else {
            System.out.println(nombre + " no tiene ningún examen para vigilar.");
        }
    }
}
