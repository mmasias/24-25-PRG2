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
        if (programador) {
            this.examen = new Examen();
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
            System.out.println("Examen: " + examen.getTitulo());
            System.out.println("Vigilado por: " + (vigilante != null ? vigilante.nombre : "Nadie"));

            for (int i = 0; i < examen.getPreguntas().length; i++) {
                System.out.println("Pregunta " + (i + 1) + ": \"" + examen.getPreguntas()[i] + "\"");
            }
        }
    }
}