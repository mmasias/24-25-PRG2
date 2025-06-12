class Main {
    public static void main(String[] args){
        String[] preguntas = {"Que es una variable?", "Que es un objeto?", "Cual es la vista publica de este objeto?"};
        Asignatura asignatura = new Asignatura("Programacion 2", 6, "PRG2");
        Profesor profesor = new Profesor("Manuel Muñoz", "Z1627692XAW2586", asignatura);
        Examen examen = new Examen("Examen final", profesor, preguntas);
        Universidad universidad = new Universidad("Uneatlantico");

        System.out.println("Universidad: " + universidad.Nombre());
        System.out.println("Profesor: " + profesor.Datos());
        System.out.println("Asignatura: " + asignatura.Titulo());
        System.out.println("Examen: " + examen.NombreExamen());
        System.out.println("Vigilado por: " + examen.ProfesorVigilando());
        examen.DarPreguntas();
    }
}
