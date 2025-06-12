public class ExamenFinal {
    public static void main(String[] args) {
        Universidad uneatlantico = new Universidad("Universidad Europea del atlantico");

        Profesor ibuprofeno = uneatlantico.contratarProfesor("Ibuprofeno del jesus fernandez gomez de la piedra y cansado", "244455555X");
        Profesor dalsy = uneatlantico.contratarProfesor("Dalsy Piedad de los remedios albornoz del camp", "666456665X");

        Asignatura prg2 = uneatlantico.crearAsignatura("Programación 2", "PRG2", 6);

        uneatlantico.asignarAsignatura(ibuprofeno, prg2);

        Examen examenFinal = ibuprofeno.crearExamen("Examen Final");
        examenFinal.agregarPregunta("Vista publica de clases");
        examenFinal.agregarPregunta("Vista publica de los objetos");
        examenFinal.agregarPregunta("vista privada de clases");

        ibuprofeno.entregarExamen(dalsy, examenFinal);

        System.out.println(uneatlantico.mostrarEscenario());
    }
}
