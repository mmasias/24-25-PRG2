import java.util.List;

public class Profesor1 {

    public Profesor1() {

    }

    public Examen generarExamen(CulturaGeneral cultura) {
        Examen examen = new Examen();
        List<String> datos = cultura.getConocimientos();

        for (String dato : datos) {
            String pregunta = this.generarPregunta(dato);
            String respuesta = this.extraerRespuesta(dato);

            if (pregunta != null && respuesta != null) {
                examen.agregarPregunta(pregunta);
                examen.agregarRespuesta(respuesta);
            }
        }

        return examen;
    }

    private String generarPregunta(String dato) {
        if (dato.contains("París"))
            return "¿Cuál es la capital de Francia?";
        if (dato.contains("Cervantes"))
            return "¿Quién escribió Don Quijote?";
        if (dato.contains("Marte"))
            return "¿Qué planeta es conocido como el planeta rojo?";
        if (dato.contains("1969"))
            return "¿En qué año llegó el hombre a la Luna?";
        if (dato.contains("Pacífico"))
            return "¿Cuál es el océano más grande del mundo?";
        if (dato.contains("Mona Lisa"))
            return "¿Quién pintó La Mona Lisa?";
        if (dato.contains("chino mandarín"))
            return "¿Cuál es el idioma más hablado en el mundo?";
        if (dato.contains("oxígeno"))
            return "¿Qué gas necesitamos para respirar?";
        if (dato.contains("litio"))
            return "¿Cuál es el metal más ligero?";
        if (dato.contains("Italia"))
            return "¿Qué país tiene forma de bota?";
        return null;
    }

    private String extraerRespuesta(String dato) {
        if (dato.contains("París"))
            return "París";
        if (dato.contains("Cervantes"))
            return "Miguel de Cervantes";
        if (dato.contains("Marte"))
            return "Marte";
        if (dato.contains("1969"))
            return "1969";
        if (dato.contains("Pacífico"))
            return "Océano Pacífico";
        if (dato.contains("Mona Lisa"))
            return "Leonardo da Vinci";
        if (dato.contains("chino mandarín"))
            return "Chino mandarín";
        if (dato.contains("oxígeno"))
            return "Oxígeno";
        if (dato.contains("litio"))
            return "Litio";
        if (dato.contains("Italia"))
            return "Italia";
        return null;
    }
}
