public class Profesores {

    public static String[] profesores;
    public static String[] identificacionProfesor;
    String nombre;

    static {
        public static String[] profesores;
    public static String[] identificacionProfesor;
    }

    public Profesores(String nombre) {
        this.nombre = nombre;
    }

    public Examen crearExamen() {
        String[] preguntas = {
            "¿Capital de Francia?",
            "¿Resultado de 2+2?",
            "¿Color del cielo?"
        };

        String[] selecciones = {
            "A) París B) Roma C) Madrid",
            "A) 3 B) 4 C) 5",
            "A) Rojo B) Azul C) Verde"
        };

        String[] respuestas = {"A", "B", "B"};

        Examen examen = new Examen(preguntas, respuestas, selecciones);
        System.out.println(" Profesor " + nombre + " ha creado un examen.");
        return examen;
    }

    public void preguntarPreguntas(String asignatura) {
        System.out.println(nombre + " está preguntando en el examen de '" + asignatura + "'.");
    }

    public void entregarAVigilante(String vigilanteNombre, Universidad universidad) {
        for (Profesores asignado : universidad.profesorAsignadoAExamen) {
            if (asignado != null && asignado.getNombre().equals(nombre)) {
                System.out.println(" El profesor " + nombre + " no puede ser vigilante. (El da esta materia)");
                return;
            }
        }
        System.out.println(" El profesor " + nombre + " entregó el examen al vigilante: " + vigilanteNombre);
    }

    
    public String getNombre() {
        return nombre;
    }
}
