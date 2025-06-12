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
        if (programador && asignatura != null && asignatura.toLowerCase().contains("programacion")) {
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
        if (asignatura.toLowerCase().contains("programacion")) {
            this.programador = true;
        }
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
