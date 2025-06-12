package entregas.uretaAaron;
public class App {
    public static void main(String[] args) {
        Universidad uni = new Universidad("Universidad Europea del Atlántico");

        Profesor profe = new Profesor("Ibuprofeno del Jesús Fernández de la Piedra y Cansado", "24445555X");
        uni.contratarProfesor(profe);

        Asignatura prg2 = new Asignatura("Programación 2", "PRG2", 6);
        uni.asignarAsignatura(prg2);

        profe.crearExamen();

        ProfesorExterno vigilante = new ProfesorExterno("Dalsy Piedad de los Remedios Albornoz del Campo", "66645666X");

        profe.entregarExamen(vigilante);

        uni.imprimirInformacion();
    }
}
