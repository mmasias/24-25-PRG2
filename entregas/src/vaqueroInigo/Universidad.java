package vaqueroInigo;

public class Universidad {
    private String nombre;
    private Profesor profesor;
    private Vigilante vigilante;
    private Asignatura asignatura;
    private Examen examen;

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public void contratacionProfesor(String nombre, String dni) {
        this.profesor = new Profesor(nombre, dni);
    }

    public void contratacionVigilante(String nombre, String dni) {
        this.vigilante = new Vigilante(nombre, dni);
    }

    public void creacionAsignatura(String nombre) {
        this.asignatura = new Asignatura(nombre);
        asignatura.asignacionProfesor(profesor);
        profesor.asignacionAsignatura(asignatura);
    }

    public void prepararExamen(String nombreExamen, String p1, String p2, String p3) {
        this.examen = profesor.creacionExamen(nombreExamen);
        profesor.creacionPreguntas(examen, p1, p2, p3);
        examen.entregarAVigilante(vigilante);
    }

    public void mostrar() {
        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre() + " / DNI: " + profesor.getDni());
        System.out.println("Asignatura: " + asignatura.getNombre());
        System.out.println("Examen: " + examen.getNombre());
        vigilante.vigilarExamen(examen);
        examen.mostrarPreguntas();
    }

    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");
        uni.contratacionProfesor("Dr. Jesús Fernández Gómez de la Piedra y Canado", "24445555X");
        uni.contratacionVigilante("Daisy Piedad de los Remedios Albornoz del Campo", "66665666X");
        uni.creacionAsignatura("Programación 2 - PROG - 6 Créditos");

        uni.prepararExamen(
            "Examen Final",
            "Vista publica de clases",
            "Vista publica de objetos",
            "Vista privada de clases"
        );

        uni.mostrar();
    }
}
