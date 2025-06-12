
public class Main {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        uni.crearAsignatura("Programacion 2", 6);
        Asignatura prog = uni.getAsignatura("Programacion 2");

        uni.contratarProfesor("Ibuprofeno del Jesús Fernández Gómez de la Piedra y Cansado", "244455555X");
        Profesor profe = uni.getProfesor("244455555X");
        profe.asignarAsignatura(prog);

        Examen examen = profe.crearExamen();

        uni.contratarVigilante("Dalsy Piedad de los Remedios Albornoz del Campo", "666456665X");
        Vigilante vig = uni.getVigilante("666456665X");
        examen.entregarAVigilante(vig);

        examen.mostrarResumen("Universidad Europea del Atlántico", profe);
    }
}

