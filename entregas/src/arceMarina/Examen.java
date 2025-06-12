package arceMarina;

class Examen {
    private String titulo;
    private String[] preguntas;
    private String asignatura;

    public Examen(String asignatura) {
        this.titulo = "Examen final";
        this.preguntas = generarPreguntas();
        this.asignatura = asignatura.toLowerCase().contains("programacion") ? asignatura : null;
    }

    private String[] generarPreguntas() {
        return new String[] {
            "Vista pública clases",
            "Vista pública de objetos",
            "Vista privada de clases"
        };
    }
}
