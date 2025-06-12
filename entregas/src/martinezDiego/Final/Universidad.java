package martinezDiego.Final;

public class Universidad {

    private String nombre = "Universidad Europea del Atlántico";

    Asignatura asignatura = new Asignatura("Estructura de datos y algoritmos", 4, "EDA");
    Asignatura asignatura2 = new Asignatura("lenguajes de programacion", 4, "LP");

    Profesor profesor = new Profesor("manuel", 3564636, asignatura.getNombreCorto());
    Profesor profesor2 = new Profesor("ibuprofeno", 356, asignatura2.getNombreCorto());

    public void gestionarAsignaturas() {

    }

    public void imprimirDatos() {

        System.out.println("Universidad: " + nombre);
        System.out.println("Profesor: " + profesor.getNombre());
        System.out.println("Asignatura de  " + profesor.getNombre() + " -> " + profesor.getAsignatura() + "||"
                + " creditos: " + asignatura.getCreditos());
        System.out.println("Examen: " + profesor.examen1.getTipo());
        System.out.println("Vigilado por: " + profesor.asignarExamen(profesor2));
        System.out.println("Preguntas: " + profesor.examen1.getPreguntas());

    }

}
