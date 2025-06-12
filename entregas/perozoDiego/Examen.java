public class Examen {
    private String preguntas;

    private Examen(String preguntas) {
        this.preguntas = preguntas;
    }

    public static Examen crearExamenFinalDeProgramacion() {
        String contenido = "Pregunta 1: \"Vista publica de clases\"\n" +
                           "        Pregunta 2: \"Vista publica de objetos\"\n" +
                           "        Pregunta 3: \"Vista privada de clases\"";
        return new Examen(contenido);
    }

    public String getPreguntas() {
        return this.preguntas;
    }
}