package entregas.grizoniManuela;


public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        Profesor prof = new Profesor(
            "Ibuprofeno del Jesús Fernández Gomez de la Piedra y Cansado",
            "244455555X"
        );

        Asignatura asign = new Asignatura("Programacion 2", "PRG 2", 6);

        Profesor vigil = new Profesor("Dalsy Piedad de los Remedios Albornoz del Campo", "66645666X");

        Examen examen = new Examen("Examen Final", vigil);
        examen.addPregunta(new Pregunta("Vista pública clases"));
        examen.addPregunta(new Pregunta("Vista pública de objetos"));
        examen.addPregunta(new Pregunta("Vista privada de clases"));


        System.out.println(uni);
        System.out.println(prof);
        System.out.println("    Asignatura : " + asign);
        System.out.println("          " + examen);
    }
}
