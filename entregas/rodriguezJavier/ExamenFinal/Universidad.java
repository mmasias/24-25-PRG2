public class Universidad {
    public static void main(String[] args) {

        Asignatura asignatura = new Asignatura("Programación 2", "PRG2", 6);

        Profesor profesor = new Profesor("Ibuprofeno del Jesús Fernández Gómez de la Piedra y Cansado", "244455555X");
        profesor.asignarAsignatura(asignatura);

        Examen examen = new Examen("Examen Final", asignatura);
        examen.agregarPreguntas("Vista pública clases", "Vista pública de objetos", "Vista privada de clases");

        Vigilante vigilante = new Vigilante("Dalsy Piedad de los Remedios Albornoz del Campo", "66645666X");
        vigilante.recibirExamen(examen);

        System.out.println("Universidad: Universidad Europea del Atlántico");
        System.out.println("Profesor: " + profesor.nombre + " / DNI " + profesor.dni);
        System.out.println("Asignatura: " + asignatura.nombre + " - " + asignatura.codigo + " - " + asignatura.creditos + " créditos");
        System.out.println("Examen: " + examen.titulo);
        System.out.println("Vigilado por : " + vigilante.nombre + " / DNI " + vigilante.dni);
        System.out.println("Pregunta 1: \"" + examen.pregunta1 + "\"");
        System.out.println("Pregunta 2: \"" + examen.pregunta2 + "\"");
        System.out.println("Pregunta 3: \"" + examen.pregunta3 + "\"");
    }
}
