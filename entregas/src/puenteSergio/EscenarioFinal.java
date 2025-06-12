public class EscenarioFinal {

    private final Universidad universidad;
    private final Profesor profesor;
    private final Asignatura asignatura;
    private final Examen examen;
    private final Vigilante vigilante;
    private final Console console;

    public EscenarioFinal() {
        this.console = Console.getInstance();
        this.universidad = new Universidad("Universidad Europea del Atlántico");
        this.profesor = new Profesor("Ibuprofeno del Jesús Férnandez Gómez de la Piedra y Cansado", "244455555X");
        this.asignatura = new Asignatura("Programación 2", "PRG2", 6);
        this.examen = new Examen("Examen Final");
        this.vigilante = new Vigilante("Dalsy Piedad de los Remedios Albornos del Campo", "666456665X");
    }

    public void mostrar() {
        this.console.writeln("Universidad: " + this.universidad.nombre());
        this.console.writeln("Profesor: " + this.profesor.nombreCompleto() + " / DNI " + this.profesor.dni());
        this.console.writeln("Asignatura: " + this.asignatura.descripcion());
        this.console.writeln("Examen: " + this.examen.nombre());
        this.console.writeln("Vigilado por :" + this.vigilante.nombreCompleto() + " / DNI " + this.vigilante.dni());
        int numero = 1;
        for (Pregunta pregunta : Pregunta.values()) {
            String separador = pregunta.espacioAntes() ? " :" : ":";
            this.console.writeln("Pregunta " + numero + separador + " \"" + pregunta.enunciado() + "\"");
            numero++;
        }
    }
}