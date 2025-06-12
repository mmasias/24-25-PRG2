public class Universidad {
    public Profesores[] profesores = new Profesores[10];
    public String[] asignaturas = new String[10];
    public int numProfesores = 0;
    public int numAsignaturas = 0;public class Universidad {
        public Profesores[] profesores = new Profesores[10];
        public String[] asignaturas = new String[10];
        public int numProfesores = 0;
        public int numAsignaturas = 0;
        public final String nombre = "Universidad Europea del Atlantico";
    
        public Universidad() {
            Profesores profesor1 = new Profesores("Profesor X");
            Profesores profesor2 = new Profesores("Profesor Y");
    
            contratar(profesor1);
            contratar(profesor2);
    
            crearAsignatura("programación 2 - PRG2 - 6 creditos");
            asignar(profesor1, "programación 2 - PRG2 - 6 creditos");
    
            profesor1.crearExamen();
            profesor1.entregar(profesor2);
    
            System.out.println("Universidad: " + nombre);
            System.out.println("Profesor: " + profesor1.nombre);
            System.out.println("Asignatura: " + profesor1.asignatura);
            System.out.println("Examen: " + profesor1.examen.titulo);
            System.out.println("Vigilado por: " + profesor2.nombre);
    
            for (int i = 0; i < profesor1.examen.preguntas.length; i++) {
                System.out.println("Pregunta " + (i + 1) + ": \"" + profesor1.examen.preguntas[i] + "\"");
            }
        }
    
        public void contratar(Profesores profesor) {
            if (numProfesores < profesores.length) {
                profesores[numProfesores++] = profesor;
            }
        }
    
        public void crearAsignatura(String asignatura) {
            if (numAsignaturas < asignaturas.length) {
                asignaturas[numAsignaturas++] = asignatura;
            }
        }
    
        public void asignar(Profesores profesor, String asignatura) {
            if (existeAsignatura(asignatura)) {
                profesor.asignatura = asignatura;
                if (asignatura.toLowerCase().contains("programacion")) {
                    profesor.programacion = true;
                }
            }
        }
    
        private boolean existeAsignatura(String asignatura) {
            for (int i = 0; i < numAsignaturas; i++) {
                if (asignaturas[i].equalsIgnoreCase(asignatura)) {
                    return true;
                }
            }
            return false;
        }
    }
}    