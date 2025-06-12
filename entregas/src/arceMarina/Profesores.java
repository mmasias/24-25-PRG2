package arceMarina;

class Profesores {
    private String nombre;
    private boolean programador;
    private String asignatura;
    private Examen examen;
    private Profesores vigilante;

    public Profesores(String nombre) {
        this.nombre = nombre;
    }

    public void crearExamen() {
        if (programador && asignatura != null && contieneProgramacion(asignatura)) {
            this.examen = new Examen(asignatura);
        }
    }

    public void entregar(Profesores otro) {
        if (this.examen != null && puedeVigilar(otro)) {
            otro.vigilar();
            this.vigilante = otro;
        }
    }

    public void vigilar() {
        System.out.println(nombre + " está preparado para vigilar.");
    }

    void asignar(String asignatura) {
        asignarAsignatura(asignatura);
    }

    void mostrarDatos() {
        imprimirInformacion();
    }

    private boolean puedeVigilar(Profesores otro) {
        return !otro.programador && (otro.asignatura == null || otro.asignatura.isEmpty());
    }

    private void asignarAsignatura(String asignatura) {
        this.asignatura = asignatura;
        if (contieneProgramacion(asignatura)) {
            this.programador = true;
        }
    }

    private boolean contieneProgramacion(String texto) {
        return removerTildes(texto.toLowerCase()).contains("programacion");
    }

    private String removerTildes(String texto) {
        return texto.replace("á", "a")
                    .replace("é", "e")
                    .replace("í", "i")
                    .replace("ó", "o")
                    .replace("ú", "u");
    }

    private void imprimirInformacion() {
        System.out.println("Profesor: " + nombre);
        System.out.println("Asignatura: " + asignatura);

        if (examen != null) {
            System.out.println("Examen: Examen final");

            if (vigilante != null) {
                System.out.println(vigilante.nombre + " está vigilando el examen de " + nombre);
            } else {
                System.out.println("Nadie está vigilando este examen.");
            }

            System.out.println("Preguntas del examen:");
            String[] preguntas = {
                "Vista pública clases",
                "Vista pública de objetos",
                "Vista privada de clases"
            };

            for (String pregunta : preguntas) {
                System.out.println("- " + pregunta);
            }
        }
    }
}
