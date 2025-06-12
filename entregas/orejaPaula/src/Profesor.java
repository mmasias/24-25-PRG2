public class Profesor extends Persona {
    private Asignatura asignatura;
    private Examen examen;

    public Profesor(String nombre, String dni) {
        super(nombre, dni);
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean imparteAsignatura() {
        return asignatura != null;
    }

    public void crearExamen() {
        if (imparteAsignatura()) {
            this.examen = new Examen("Examen Final");
            examen.agregarPregunta("Vista pública de clases");
            examen.agregarPregunta("Vista pública de objetos");
            examen.agregarPregunta("Vista privada con herencia");
        } else {
            System.out.println(nombre + " no imparte asignatura. No puede crear examen.");
        }
    }

    public void entregarExamen(Profesor otro) {
        if (this.examen != null && !otro.imparteAsignatura()) {
            System.out.println(nombre + " entrega el examen a " + otro.nombre);
        } else {
            System.out.println("No se puede entregar el examen.");
        }
    }

    @Override
    public void mostrar() {
        System.out.println("Profesor: " + nombre + " / DNI: " + dni);
        if (asignatura != null) {
            System.out.println("Imparte: " + asignatura.getNombre());
        } else {
            System.out.println("No imparte ninguna asignatura.");
        }
    }
}

