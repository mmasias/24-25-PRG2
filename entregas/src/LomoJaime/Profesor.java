package LomoJaime;

public class Profesor {
    private String nombre;
    private String dni;
    private Asignatura asignatura;
    private Examen examen;
    private Examen examenVigilado;

    public Profesor(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public void asignarAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
        System.out.println(nombre + " ha sido asignado a la asignatura: " + asignatura.getNombre());
    }

    public void crearExamen() {
        if (asignatura != null) {
            this.examen = new Examen(asignatura);
            System.out.println(nombre + " ha creado un examen para la asignatura: " + asignatura.getNombre());
        } else {
            System.out.println(nombre + " no tiene asignatura asignada. No puede crear examen.");
        }
    }

    public void entregarExamen(Profesor vigilante) {
        if (this.examen != null && vigilante.asignatura == null) {
            vigilante.examenVigilado = this.examen;
            System.out.println(vigilante.nombre + " está vigilando el examen de la asignatura: " + this.asignatura.getNombre());
            System.out.println(nombre + " ha entregado el examen a " + vigilante.nombre + " para su vigilancia.");
        } else if (this.examen == null) {
            System.out.println(nombre + " no ha creado ningún examen.");
        } else {
            System.out.println(vigilante.nombre + " no puede vigilar exámenes porque tiene asignatura.");
        }
    }

    public void mostrarExamenVigilado() {
        if (examenVigilado != null) {
            examenVigilado.mostrar(); // Método visible solo dentro del paquete
        } else {
            System.out.println("No hay examen asignado para vigilancia.");
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}
