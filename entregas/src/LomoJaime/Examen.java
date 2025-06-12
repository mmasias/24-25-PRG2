package LomoJaime;

class Examen {
    private Asignatura asignatura;
    private String[] preguntas;

    public Examen(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.preguntas = new String[3];
        generarPreguntas();
    }

    private void generarPreguntas() {
        preguntas[0] = "¿Qué es la encapsulación en POO?";
        preguntas[1] = "¿Diferencia entre herencia y composición?";
        preguntas[2] = "Explica el principio de responsabilidad única.";
    }

    // Solo accesible dentro del paquete LomoJaime
    void mostrar() {
        for (int i = 0; i < preguntas.length; i++) {
            System.out.println("Pregunta " + (i + 1) + ": " + preguntas[i]);
        }
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
}
