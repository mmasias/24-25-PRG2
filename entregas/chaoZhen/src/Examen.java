public class Examen {

    public Examen(String[] preguntas, String[] respuestas, String[] selecciones) {
        private String preguntas[];
        private String respuestas[];
        private String selecciones[];
    }

    public int corregir(String respuestasAlumno[]) {
        int correctas = 0;
        for (int i = 0; i < respuestas.length; i++) {
            if (respuestas[i].equalsIgnoreCase(respuestasAlumno[i])) {
                correctas++;
            }
        }
        return correctas;
    }

    public String[] getPreguntas() {
        return preguntas;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public String[] getSelecciones() {
        return selecciones;
    }
}
