package arceMarina;

class Profesor {
    private String nombre;
    private boolean programador;
    private String asignatura;
    private Examen examen;
    private Profesor vigilante;

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public void crearExamen() {
        if (programador && asignatura != null && asignatura.toLowerCase().contains("programacion")) {
            this.examen = new Examen(asignatura);
        }
    }

    public void entregar(Profesor otro) {
        if (this.examen != null && puedeVigilar(otro)) {
            otro.vigilar();
            this.vigilante = otro;
        }
    }

    public void vigilar() {
        
    }

    void asignar(String asignatura) {
        asignarAsignatura(asignatura);
    }

    void mostrarDatos() {
        imprimirInformacion();
    }

    private boolean puedeVigilar(Profesor otro) {
        return !otro.programador && (otro.asignatura == null || otro.asignatura.isEmpty());
    }

    private void asignarAsignatura(String asignatura) {
        this.asignatura = asignatura;
        if (asignatura.toLowerCase().contains("programacion")) {
            this.programador = true;
        }
    }

    private void imprimirInformacion() {
        System.out.println("Profesor: " + nombre);
        System.out.println("Asignatura: " + asignatura);

        if (examen != null) {
            System.out.println("Examen: Examen final");
            System.out.println("Vigilado por: " + (vigilante != null ? vigilante.nombre : "Nadie"));

            String[] preguntas = {
                "Vista pública clases",
                "Vista pública de objetos",
                "Vista privada de clases"
            };

            for (int i = 0; i < preguntas.length; i++) {
                System.out.println("Pregunta " + (i + 1) + ": \"" + preguntas[i] + "\"");
            }
        }
    }
}
