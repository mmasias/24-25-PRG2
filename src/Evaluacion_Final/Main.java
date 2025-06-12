package Evaluacion_Final;

class Main {
    public static void main(String[] args) {
        Asignatura asignatura = new Asignatura("Programacion 2", 6);
        Profesor profesor = new Profesor("Manuel Masias", asignatura);
        Vigilante vigilante = new Vigilante("David Reyes", 232123, profesor.examen);
        Universidad universidad = new Universidad("Universidad Europea del Atlantico", profesor, vigilante);

        universidad.mostrarInformacion();
    }
}