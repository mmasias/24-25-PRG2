class Examen {
    String nombre;
    int numero_pregutas;
    String[] ExamenProgra;
    Profesor vigilante;

    public Examen(String nombre) {
        this.nombre = nombre;
        this.numero_pregutas = 3;
        this.ExamenProgra = new String[numero_pregutas];
    }

    void crearPreguntas() {
        ExamenProgra[0] = "Vista pública clases";
        ExamenProgra[1] = "Vista pública de objetos";
        ExamenProgra[2] = "Vista privada de clases";
    }
}

