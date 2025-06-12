class Examen {
    private String titulo;
    private String[] preguntas;
    private String asignatura; // asignatura a la que pertenece este examen

    public Examen(String asignatura) {
        this.titulo = "Examen final";
        this.preguntas = generarPreguntas();
        this.asignatura = asignatura.toLowerCase().contains("programacion") ? asignatura : null;
    }

    private String[] generarPreguntas() {
        return new String[]{
            "Vista pública clases",
            "Vista pública de objetos",
            "Vista privada de clases"
        };
    }
}